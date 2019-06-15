package com.hef.design11.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public class Observable implements QuackObservable{

    private ArrayList<Observer> observers = new ArrayList<>();
    private QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}
