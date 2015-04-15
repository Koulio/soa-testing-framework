//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.02 at 10:57:18 AM BST 
//


package com.ibm.soatf.config.iface.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Util is general purpose component type. Currently used for delay. It is not related to any technology an can be seen as non-functional requirement.
 * 
 * <p>Java class for UTILConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UTILConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delays">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="waitForDbPool" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="waitForQueueMsgTransfer" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="waitForErrorQueue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="waitForFTPPool" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="waitForFilePoll" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UTILConfig", propOrder = {
    "delays"
})
public class UTILConfig {

    @XmlElement(required = true)
    protected UTILConfig.Delays delays;

    /**
     * Gets the value of the delays property.
     * 
     * @return
     *     possible object is
     *     {@link UTILConfig.Delays }
     *     
     */
    public UTILConfig.Delays getDelays() {
        return delays;
    }

    /**
     * Sets the value of the delays property.
     * 
     * @param value
     *     allowed object is
     *     {@link UTILConfig.Delays }
     *     
     */
    public void setDelays(UTILConfig.Delays value) {
        this.delays = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="waitForDbPool" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="waitForQueueMsgTransfer" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="waitForErrorQueue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="waitForFTPPool" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="waitForFilePoll" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "waitForDbPool",
        "waitForQueueMsgTransfer",
        "waitForErrorQueue",
        "waitForFTPPool",
        "waitForFilePoll"
    })
    public static class Delays {

        protected Long waitForDbPool;
        protected Long waitForQueueMsgTransfer;
        protected Long waitForErrorQueue;
        protected Long waitForFTPPool;
        protected Long waitForFilePoll;

        /**
         * Gets the value of the waitForDbPool property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getWaitForDbPool() {
            return waitForDbPool;
        }

        /**
         * Sets the value of the waitForDbPool property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setWaitForDbPool(Long value) {
            this.waitForDbPool = value;
        }

        /**
         * Gets the value of the waitForQueueMsgTransfer property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getWaitForQueueMsgTransfer() {
            return waitForQueueMsgTransfer;
        }

        /**
         * Sets the value of the waitForQueueMsgTransfer property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setWaitForQueueMsgTransfer(Long value) {
            this.waitForQueueMsgTransfer = value;
        }

        /**
         * Gets the value of the waitForErrorQueue property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getWaitForErrorQueue() {
            return waitForErrorQueue;
        }

        /**
         * Sets the value of the waitForErrorQueue property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setWaitForErrorQueue(Long value) {
            this.waitForErrorQueue = value;
        }

        /**
         * Gets the value of the waitForFTPPool property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getWaitForFTPPool() {
            return waitForFTPPool;
        }

        /**
         * Sets the value of the waitForFTPPool property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setWaitForFTPPool(Long value) {
            this.waitForFTPPool = value;
        }

        /**
         * Gets the value of the waitForFilePoll property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getWaitForFilePoll() {
            return waitForFilePoll;
        }

        /**
         * Sets the value of the waitForFilePoll property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setWaitForFilePoll(Long value) {
            this.waitForFilePoll = value;
        }

    }

}