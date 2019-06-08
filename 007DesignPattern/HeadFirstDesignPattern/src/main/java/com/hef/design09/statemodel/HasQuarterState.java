package com.hef.design09.statemodel;

import java.util.Random;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class HasQuarterState extends State{

    private Random randomwinnder = new Random(System.currentTimeMillis());
    private GumballMachine gumballMachine;


    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomwinnder.nextInt(10);
        if((winner == 0) && (gumballMachine.getCount() > 1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }
}
