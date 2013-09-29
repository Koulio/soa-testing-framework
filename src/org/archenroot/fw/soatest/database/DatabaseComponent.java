/*
 * Copyright (C) 2013 zANGETSu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.archenroot.fw.soatest.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.archenroot.fw.soatest.SoaTestingFrameworkComponent;
import org.archenroot.fw.soatest.SoaTestingFrameworkComponentType;
import org.archenroot.fw.soatest.SoaTestingFrameworkComponentType.ComponentOperation;
import org.archenroot.fw.soatest.configuration.ConnectionIdentification;
import org.archenroot.fw.soatest.configuration.DatabaseConfiguration;
import org.archenroot.fw.soatest.configuration.DatabaseTypeEnum;

/**
 *
 * @author zANGETSu
 */
public class DatabaseComponent extends SoaTestingFrameworkComponent {

    public static Set<SoaTestingFrameworkComponentType.ComponentOperation> supportedOperations = ComponentOperation.databaseOperations;

    private ComponentOperation databaseOperation = null;
    private DatabaseConfiguration databaseConfiguration = null;
    private ConnectionIdentification connectionIdentification = null;

    private String connectionName;
    private String databaseType;
    private String driverClassName;
    private String hostName;
    private BigInteger port;
    private String userName;
    private String password;
    private String serviceId;
    private String connectAs;
    private String objectName;
    private String insertSqlScriptFileName;
    private String selectSqlScriptFileName;
    private String updateSqlScriptFileName;
    private String deleteSqlScriptFileName;

    private String jdbcUrl;
    private Connection conn;

    public DatabaseComponent(DatabaseConfiguration databaseConfiguration) {
        super(SoaTestingFrameworkComponentType.DATABASE);
        this.databaseConfiguration = databaseConfiguration;
        this.connectionIdentification = this.databaseConfiguration.getConnectionIdentification();
        constructComponent();
    }

    @Override
    protected final void constructComponent() {

        connectionName = this.databaseConfiguration.getConnectionIdentification().getConnectionName();
        databaseType = DatabaseTypeEnum.ORACLE.value();
        driverClassName = this.connectionIdentification.getDriverClassName();
        hostName = this.connectionIdentification.getHostName();
        port = this.connectionIdentification.getPort();
        userName = this.connectionIdentification.getUserName();
        password = this.connectionIdentification.getPassword();
        serviceId = this.connectionIdentification.getServiceId();
        connectAs = this.connectionIdentification.getConnectAs();
        objectName = this.connectionIdentification.getObjectName();
        insertSqlScriptFileName = this.connectionIdentification.getInsertSqlScriptFileName();
        selectSqlScriptFileName = this.connectionIdentification.getSelectSqlScriptFileName();
        updateSqlScriptFileName = this.connectionIdentification.getUpdateSqlScriptFileName();
        deleteSqlScriptFileName = this.connectionIdentification.getDeleteSqlScriptFileName();

        jdbcUrl = constructJdbcUrl(this.hostName, this.port, this.serviceId);
        try {
            Class.forName(this.driverClassName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conn = DriverManager.getConnection(
                    this.jdbcUrl, this.userName, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void executeOperation(ComponentOperation componentOperation) {
        Set<ComponentOperation> supportedOperations = SoaTestingFrameworkComponentType.ComponentOperation.databaseOperations;

        if (supportedOperations.contains(componentOperation)) {
            try {
                throw new UnsupportedComponentOperation();
            } catch (UnsupportedComponentOperation ex) {
                Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        switch (componentOperation) {
            case GENERATE_INSERT_DYNAMICALLY_ONE_ROW:
                generateInsertDynamicallyOneRow();
                break;
            case EXECUTE_INSERT_FROM_FILE:
        try {
            executeInsertFromFile();
        } catch (IOException ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
            default:
        }
    }

    private void generateInsertDynamicallyOneRow() {
        try {
            StatementGenerator sg = new StatementGenerator(conn, objectName, insertSqlScriptFileName);
            sg.generateOneRowSampleInsertStatement();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeInsertFromFile() throws FileNotFoundException, IOException, SQLException {
        StatementExecutor se = new StatementExecutor(conn, false, true);
        Reader r = new FileReader(new File(this.insertSqlScriptFileName));
        se.runScript(r);
    }

    private static String constructJdbcUrl(String hostName, BigInteger port, String serviceId) {
        return "jdbc:oracle:thin:@"
                + hostName + ":"
                + port.toString() + ":"
                + serviceId;
    }

    protected static void writeStatementToFile(String statement, String pathToFile) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(pathToFile));
            fw.write(statement);
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
