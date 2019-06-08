package com.hef.design09.statemodel;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class GumballMachine {

    private String locatioin;

    private State soldState;
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State winnerState;

    private State state;
    private int count;

    public GumballMachine(String locatioin, int count){
        this(count);
        this.locatioin = locatioin;
    }

    public GumballMachine(int count) {
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);

        this.count = count;
        if(count>0){
            state = noQuarterState;
        }else {
            state = soldOutState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turncrank(){
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    public void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count != 0){
            count = count -1;
        }
    }

    public String getLocatioin() {
        return locatioin;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
