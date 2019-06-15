package com.hef.design11.dacks;

import com.hef.design11.Quackable;
import com.hef.design11.observer.Observable;
import com.hef.design11.observer.Observer;

/**
 * 鸭鸣器
 * @Date 2019-06-14
 * @Author lifei
 */
public class DuckCall implements Quackable {

    private Observable observable;

    public DuckCall() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Kwak");
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
