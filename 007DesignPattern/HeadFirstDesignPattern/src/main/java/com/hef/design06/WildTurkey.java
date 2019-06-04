package com.hef.design06;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble gobble...");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance...");
    }
}
