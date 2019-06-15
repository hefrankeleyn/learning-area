package com.hef.design11.decorators;

import com.hef.design11.Quackable;
import com.hef.design11.observer.Observer;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public class QuackCounter implements Quackable {

    private Quackable duck;
    private static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks ++;
    }

    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
