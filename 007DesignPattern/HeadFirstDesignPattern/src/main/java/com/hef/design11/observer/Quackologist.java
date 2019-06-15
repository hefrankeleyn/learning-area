package com.hef.design11.observer;

/**
 * @Date 2019-06-15
 * @Author lifei
 */
public class Quackologist implements Observer{
    public Quackologist() {
    }

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
