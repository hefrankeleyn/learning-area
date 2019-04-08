package com.hef.order.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 其他属性并没有添加注解，除非将属性设置为顺时态(transient), 否则Java对象中所有的域都会持久化为文案中的域。
 * 如果不使用 @Field注解进行设置的话，那么文档中的名字将会与对应的Java属性相同
 */
//  这是一个文档
@Document
public class Order {
    // 指定Id
    /**
     * 指定文档的id
     */
    @Id
    private String id;
    // 覆盖默认的域名
    @Field("client")
    private String customer;

    private String type;
    /**
     * 行条目只是同一个订单文档里面内嵌的一部分
     * 没有必要为这种关联关系添加任何注解
     */
    private Collection<Item> items = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}
