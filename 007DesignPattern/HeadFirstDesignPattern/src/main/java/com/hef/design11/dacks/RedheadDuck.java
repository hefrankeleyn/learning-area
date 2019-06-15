package com.hef.design11.dacks;

import com.hef.design11.Quackable;
import com.hef.design11.observer.Observable;
import com.hef.design11.observer.Observer;

/**
 * 红头鸭
 * @Date 2019-06-14
 * @Author lifei
 */
public class RedheadDuck implements Quackable {

    private Observable observable;

    public RedheadDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack.");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
