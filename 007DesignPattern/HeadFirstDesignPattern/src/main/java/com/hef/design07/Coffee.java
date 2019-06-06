package com.hef.design07;

/**
 * @Date 2019-06-06
 * @Author lifei
 */
public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk....");
    }
}
