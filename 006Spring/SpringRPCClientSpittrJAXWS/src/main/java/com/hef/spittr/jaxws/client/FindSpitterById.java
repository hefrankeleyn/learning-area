
package com.hef.spittr.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findSpitterById complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="findSpitterById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findSpitterById", propOrder = {
    "arg0"
})
public class FindSpitterById {

    protected long arg0;

    /**
     * 获取arg0属性的值。
     * 
     */
    public long getArg0() {
        return arg0;
    }

    /**
     * 设置arg0属性的值。
     * 
     */
    public void setArg0(long value) {
        this.arg0 = value;
    }

}
