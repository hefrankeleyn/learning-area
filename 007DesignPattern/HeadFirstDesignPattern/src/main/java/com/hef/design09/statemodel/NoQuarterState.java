package com.hef.design09.statemodel;


/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class NoQuarterState extends State{

    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
}
