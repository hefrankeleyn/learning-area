package com.hef.design02_02;


import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019-05-28
 * @Author lifei
 */
public class Observable {

    private boolean changed;

    private List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public synchronized void registerObserver(Observer observer){
        observers.add(observer);
    }

    public synchronized void removeObserver(Observer observer){
        int i = observers.indexOf(observer);
        if (i>=0){
            observers.remove(i);
        }
    }

    public synchronized void setChanged() {
        this.changed = true;
    }

    public synchronized void notifyObservers(Object arg){
        if(changed){
            for (Observer o :
                    observers) {
                o.update(this, arg);
            }
            changed = false;
        }
    }

    public synchronized void notifyObservers(){
        notifyObservers(null);
    }


}
