
package com.hef.spittr.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findSpitterByIdResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="findSpitterByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://jaxws.remoting.spittr.hef.com/}spitter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findSpitterByIdResponse", propOrder = {
    "_return"
})
public class FindSpitterByIdResponse {

    @XmlElement(name = "return")
    protected Spitter _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Spitter }
     *     
     */
    public Spitter getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Spitter }
     *     
     */
    public void setReturn(Spitter value) {
        this._return = value;
    }

}
