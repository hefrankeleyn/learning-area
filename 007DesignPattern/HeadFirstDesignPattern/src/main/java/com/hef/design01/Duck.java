package com.hef.design01;

import com.hef.design01.behaviors.FlyBehavior;
import com.hef.design01.behaviors.QuackBehavior;

/**
 *
 * @Date 2019-05-28
 * @Author lifei
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    public Duck(){}
    /**
     * 每一个鸭子都会叫
     */
    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void swim(){
        System.out.println("Swiming...");
    }

    /**
     * 每一个子类实现自己的diaplay行为
     */
    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
