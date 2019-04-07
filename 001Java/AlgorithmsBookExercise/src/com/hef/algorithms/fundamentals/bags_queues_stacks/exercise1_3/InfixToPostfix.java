package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;
import com.hef.commons.StdIn;
import com.hef.commons.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * http://interactivepython.org/runestone/static/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
 */
public class InfixToPostfix {



    public static void main(String[] args) {
        String s1 = "(2 + 3) * 5 + 6 + 9 * 2";
        String rs = solution(s1);
        System.out.println(rs);
    }

    private static void solution2(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
            else if (s.equals("(")) StdOut.print("");
            else StdOut.print(s + " ");
        }
    }

    /**
     * 优先级
     * @return
     */
    private static final Map<Character, Integer> precedences(){
        Map<Character, Integer>  precedences = new HashMap<>();
        precedences.put('(', 1);
        precedences.put('-', 2);
        precedences.put('+', 2);
        precedences.put('*', 3);
        precedences.put('/', 3);
        return precedences;
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> pres = precedences();
        for(int i=0; i<s.length(); i++){

            if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(s.charAt(i) + "") || "0123456789".contains(s.charAt(i) + "")){
                sb.append(s.charAt(i));
            }else if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == ')'){
                char operator = stack.pop();
                while (operator != '('){
                    sb.append(operator);
                    operator = stack.pop();
                }
            }else if (s.charAt(i) == ' '){

            }else {
                while (!stack.isEmpty() && pres.get(s.charAt(i)) <= pres.get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(s.charAt(i));

            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        char[] rs = sb.toString().toCharArray();
        String[] r = new String[rs.length];
        for (int j=0; j<rs.length; j++){
            r[j] = rs[j] + "";
        }
        return String.join(" ", r);
    }
}
