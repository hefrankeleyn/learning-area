package com.hef.design11.observer;

/**
 * 被观察者对象
 */
public interface QuackObservable {

    void registerObserver(Observer observer);

    void notifyObservers();
}
