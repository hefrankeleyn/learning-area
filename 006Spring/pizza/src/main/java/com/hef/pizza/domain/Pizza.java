package com.hef.pizza.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable {

    private PizzaSize size;
    private List<Topping> toppings;

    public Pizza(){
        this.size = PizzaSize.LARGE;
        this.toppings = new ArrayList<>();
    }

    public Pizza(PizzaSize size, List<Topping> toppings) {
        this.size = size;
        this.toppings = toppings;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
    public void setToppings(String[] toppingStrings) {
        for (int i = 0; i < toppingStrings.length; i++) {
            toppings.add(Topping.valueOf(toppingStrings[i]));
        }
    }
}
