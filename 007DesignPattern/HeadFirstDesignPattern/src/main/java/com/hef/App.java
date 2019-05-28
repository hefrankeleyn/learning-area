package com.hef;

import com.hef.design01.Duck;
import com.hef.design01.MallardDuck;
import com.hef.design01.behaviors.impl.FlyNoWay;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
    }
}
