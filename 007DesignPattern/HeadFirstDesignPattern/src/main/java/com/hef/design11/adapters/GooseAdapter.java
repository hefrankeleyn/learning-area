package com.hef.design11.adapters;

import com.hef.design11.Quackable;
import com.hef.design11.gooses.Goose;
import com.hef.design11.observer.Observable;
import com.hef.design11.observer.Observer;

/**
 * 适配器模式
 * @Date 2019-06-14
 * @Author lifei
 */
public class GooseAdapter implements Quackable {

    private Observable observable;

    public GooseAdapter() {
        observable = new Observable(this);
    }

    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
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
