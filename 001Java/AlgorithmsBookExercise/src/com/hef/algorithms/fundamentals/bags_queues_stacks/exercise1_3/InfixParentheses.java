package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;

/**
 * @Description Write a program that takes from standard input an expression without left parentheses and prints the
 * equivalent with the parentheses inserted. For example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 *
 * @author lifei
 * @date 2019-04-06
 */
public class InfixParentheses {

    public static void main(String[] args) {

        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String rs = infixParent(s);
        System.out.println(rs);
    }

    public static String infixParent(String s){
        Stack<Character> operators = new Stack<>();
        Stack<String> operants = new Stack<>();
        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    String operant = "";
                    operant += s.charAt(i);
                    operants.push(operant);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    operators.push(s.charAt(i));
                    break;
                case ')':
                    String a = operants.pop();
                    String b = operants.pop();
                    Character opt = operators.pop();
                    String r = "( " + b + " " + opt + " " + a + " )";
                    operants.push(r);
                    break;
                case ' ':
                    break;
            }
        }
        return operants.pop();
    }
}
