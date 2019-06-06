package com.hef.design07;

/**
 * @Date 2019-06-06
 * @Author lifei
 */
public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon...");
    }
}
