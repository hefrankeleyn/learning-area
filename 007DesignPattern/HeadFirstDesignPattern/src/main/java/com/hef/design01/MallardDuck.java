package com.hef.design01;

import com.hef.design01.behaviors.impl.FlyWithWings;
import com.hef.design01.behaviors.impl.Quack;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new Quack();
    }


    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
