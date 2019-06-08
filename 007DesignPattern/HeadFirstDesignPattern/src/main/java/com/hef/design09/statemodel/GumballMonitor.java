package com.hef.design09.statemodel;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class GumballMonitor {

    private GumballMachine gumballMachine;

    public GumballMonitor(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report(){
        System.out.println("Gumball Machine: " + gumballMachine.getLocatioin());
        System.out.println("Current inventory: " + gumballMachine.getCount() + " gumballs");
        System.out.println("Current state: " + gumballMachine.getSoldOutState());
    }
}
