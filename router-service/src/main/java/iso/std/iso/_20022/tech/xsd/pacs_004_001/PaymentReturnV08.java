//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.29 at 10:07:38 AM GMT+10:00 
//


package iso.std.iso._20022.tech.xsd.pacs_004_001;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentReturnV08 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentReturnV08">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.08}GroupHeader72"/>
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.08}OriginalGroupHeader12" minOccurs="0"/>
 *         &lt;element name="TxInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.08}PaymentTransaction87" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.08}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReturnV08", propOrder = {
    "grpHdr",
    "orgnlGrpInf",
    "txInf",
    "splmtryData"
})
public class PaymentReturnV08 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader72 grpHdr;
    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupHeader12 orgnlGrpInf;
    @XmlElement(name = "TxInf")
    protected List<PaymentTransaction87> txInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader72 }
     *     
     */
    public GroupHeader72 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader72 }
     *     
     */
    public void setGrpHdr(GroupHeader72 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the orgnlGrpInf property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader12 }
     *     
     */
    public OriginalGroupHeader12 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * Sets the value of the orgnlGrpInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader12 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupHeader12 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * Gets the value of the txInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction87 }
     * 
     * 
     */
    public List<PaymentTransaction87> getTxInf() {
        if (txInf == null) {
            txInf = new ArrayList<PaymentTransaction87>();
        }
        return this.txInf;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
