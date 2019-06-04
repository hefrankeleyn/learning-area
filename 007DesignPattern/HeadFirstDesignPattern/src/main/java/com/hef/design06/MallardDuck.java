package com.hef.design06;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Quack.....");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying....");
    }
}
