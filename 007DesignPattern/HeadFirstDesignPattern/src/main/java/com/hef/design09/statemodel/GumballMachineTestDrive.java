package com.hef.design09.statemodel;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turncrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turncrank();
        gumballMachine.insertQuarter();
        gumballMachine.turncrank();

        System.out.println(gumballMachine);
    }
}
