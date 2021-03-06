
package com.wsdlclasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="AUTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCOUNT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "authAndACCOUNTNUMBER"
})
@XmlRootElement(name = "CCSCD1_ADDResponse")
public class CCSCD1ADDResponse {

    @XmlElementRefs({
        @XmlElementRef(name = "ACCOUNT_NUMBER", namespace = "http://xmlns.oracle.com/communications/ncc/2009/05/15/pi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AUTH", namespace = "http://xmlns.oracle.com/communications/ncc/2009/05/15/pi", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> authAndACCOUNTNUMBER;

    /**
     * Gets the value of the authAndACCOUNTNUMBER property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authAndACCOUNTNUMBER property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAUTHAndACCOUNTNUMBER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getAUTHAndACCOUNTNUMBER() {
        if (authAndACCOUNTNUMBER == null) {
            authAndACCOUNTNUMBER = new ArrayList<JAXBElement<String>>();
        }
        return this.authAndACCOUNTNUMBER;
    }

}
