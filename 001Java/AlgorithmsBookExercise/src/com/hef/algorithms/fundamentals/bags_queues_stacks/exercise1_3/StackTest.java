package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.commons.StdIn;

public class StackTest {

    public static void main(String[] args) {

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            System.out.println(item);
        }
        System.out.println("go home...");
    }
}
