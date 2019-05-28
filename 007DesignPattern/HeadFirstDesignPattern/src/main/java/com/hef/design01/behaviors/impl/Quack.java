package com.hef.design01.behaviors.impl;

import com.hef.design01.behaviors.QuackBehavior;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
