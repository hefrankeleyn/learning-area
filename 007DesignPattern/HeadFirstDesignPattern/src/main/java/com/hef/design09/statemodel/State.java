package com.hef.design09.statemodel;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public abstract class State {

    public void insertQuarter(){
        System.out.println("You can't insert");
    }

    public void ejectQuarter(){
        System.out.println("Quarter failed");
    }

    public void turnCrank(){
        System.out.println("Turn crank count't work");
    }

    public void dispense(){
        System.out.println("Dispense is failed");
    }
}
