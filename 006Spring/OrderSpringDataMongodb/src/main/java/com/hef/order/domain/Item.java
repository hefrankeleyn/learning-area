package com.hef.order.domain;

/**
 * 没有为Item添加@Document注解，也没有必要为它的域指定@Id。
 * 这是因为我们不会单独将Item持久化为文档。
 */
public class Item {

    private Long id;
    private Order order;
    private String product;
    private double price;
    private int quantity;

    public Item() {
    }

    public Item(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", order=" + order +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
