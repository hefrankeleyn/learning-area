package com.hef;

import org.junit.Test;

import java.util.Stack;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class StackTest {

    @Test
    public void pushTest(){
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        int i=0;
        while (hasNext(stack)){
            System.out.println(stack.peek());
            i++;
            if(i==20){
                break;
            }
        }
    }

    private boolean hasNext(Stack<String> stack){
        return true;
    }
}
