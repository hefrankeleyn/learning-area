package com.hef.pizza.domain;

import java.io.Serializable;

public class Payment implements Serializable {


    private float amount;

    public Payment() {
    }

    public Payment(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
