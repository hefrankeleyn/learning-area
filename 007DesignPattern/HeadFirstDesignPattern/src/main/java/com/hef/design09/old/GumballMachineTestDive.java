package com.hef.design09.old;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class GumballMachineTestDive {

    public static void main(String[] args) {
        GumbalMachine gumbalMachine = new GumbalMachine(5);
        System.out.println(gumbalMachine);

        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();

        System.out.println(gumbalMachine);

        gumbalMachine.insertQuarter();
        gumbalMachine.ejectQuarter();
        gumbalMachine.turnCrank();

        System.out.println(gumbalMachine);

        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();
        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();
        gumbalMachine.ejectQuarter();

        System.out.println(gumbalMachine);

        gumbalMachine.insertQuarter();
        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();
        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();
        gumbalMachine.insertQuarter();
        gumbalMachine.turnCrank();

        System.out.println(gumbalMachine);
    }
}
