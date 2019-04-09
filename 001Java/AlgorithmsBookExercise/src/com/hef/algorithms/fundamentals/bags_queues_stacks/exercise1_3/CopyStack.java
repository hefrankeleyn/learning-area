package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;

/**
 * Write a iterable Stack client that has a static method copy that takes a stack of strings as argument
 * and returns a copy of the stack. Note: This ability is a prime example of the value of having an iterator,
 * because it allows development of such functionality without changingg the basic API.
 */
public class CopyStack {

    public static Stack<String> copy(Stack<String> stack) {

        Stack<String> nStack =new Stack<>();
        for(String s:stack){
            nStack.push(s);
        }
        return nStack;
    }
}
