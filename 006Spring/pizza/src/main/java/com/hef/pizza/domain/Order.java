package com.hef.pizza.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {


    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;
    private float total;

    public Order(Customer customer, List<Pizza> pizzas, Payment payment, float total) {
        this.customer = customer;
        this.pizzas = pizzas;
        this.payment = payment;
        this.total = total;
    }

    public Order() {
        this.total=0.0f;
        this.pizzas=new ArrayList<>();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Payment getPayment() {
        return payment;
    }

    public void addPizza(Pizza pizza){
        if (pizza!=null){
            this.total=1.0f;
            pizzas.add(pizza);
        }
    }

    public float getTotal() {
        return 0.0f;
    }
}
