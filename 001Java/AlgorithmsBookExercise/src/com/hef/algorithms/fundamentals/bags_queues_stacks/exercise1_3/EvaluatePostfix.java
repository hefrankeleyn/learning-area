package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;
import com.hef.commons.StdIn;

import java.util.logging.Logger;

/**
 * Write a program EvaluatePostfix that takes a postfix expression from standard input,
 * evaluate it, and prints the value. (Piping the output of your program from the previous
 * exercise to this program gives equivalent behavior to Evaluate.)
 */
public class EvaluatePostfix {

    private static Logger logger = Logger.getLogger("com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.EvaluatePostfix");
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString().trim();
            if (s.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
                logger.info(a + "+" + b);
            }else if (s.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
                logger.info(a + "-" + b);
            }else if (s.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
                logger.info(a + "*" + b);
            }else if (s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
                logger.info(a + "/" + b);
            }else if (s.equals(":q")){
                break;
            }else if (s.equals("")){

            }else{
                stack.push(Integer.parseInt(s));
            }
        }

        int result = stack.pop();
        System.out.println("result: " + result);
    }
}
