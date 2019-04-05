package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

public class FixedCapacityStackOfStrings {

    // stack enteries
    private String[] a;
    // size
    private int N;

    // create an empty stack of capacity cap
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    // is the stack empty?
    public boolean isEmpty() { return N == 0; }
    // number of strings on the stack
    public int size() { return N; }
    // add a string
    public void push(String item){
        a[N++] = item;
    }
    // remove the most recently added string
    public String pop(){
        return a[--N];
    }

    public boolean isFull(){
        return N == a.length-1;
    }

}
