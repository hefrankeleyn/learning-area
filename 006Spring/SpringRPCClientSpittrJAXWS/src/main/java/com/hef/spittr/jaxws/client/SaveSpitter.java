
package com.hef.spittr.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>saveSpitter complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="saveSpitter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://jaxws.remoting.spittr.hef.com/}spitter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveSpitter", propOrder = {
    "arg0"
})
public class SaveSpitter {

    protected Spitter arg0;

    /**
     * 获取arg0属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Spitter }
     *     
     */
    public Spitter getArg0() {
        return arg0;
    }

    /**
     * 设置arg0属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Spitter }
     *     
     */
    public void setArg0(Spitter value) {
        this.arg0 = value;
    }

}
