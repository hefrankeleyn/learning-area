package com.hef.design11.component;

import com.hef.design11.Quackable;
import com.hef.design11.observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Date 2019-06-14
 * @Author lifei
 */
public class Flock implements Quackable {

    ArrayList<Quackable> quackers = new ArrayList<>();

    @Override
    public void quack() {
        // 迭代器模式
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
