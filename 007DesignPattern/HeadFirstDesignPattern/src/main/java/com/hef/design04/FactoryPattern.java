package com.hef.design04;

import com.hef.design04.store.ChicagoStylePizzaStore;
import com.hef.design04.store.NYStylePizzaStore;

/**
 *
 * @Date 2019-06-02
 * @Author lifei
 */
public class FactoryPattern {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
