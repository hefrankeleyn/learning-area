package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe45;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;
import com.hef.commons.StdOut;

/**
 * Stack generability. Suppose that we have a sequence of intermixed push and pop operations as with our test stack
 * client, where the integers 0, 1,….,N-1 in that order (push directives) are intermixed with N minus
 * signs (pop directives). Devise an algorithm that determines whether the intermixed sequence causes the stack to
 * underflow.(Your may use only an amount of space independent of N—you cannot store the integers in a data structure.)
 * Devise a linear-time algorithm that determines whether a given permutation can be generated as output by our test
 * client(depending on where the pop directives occur)
 * @Date 2019-04-24
 * @Author lifei
 */
public class StackGenerability {

    /**
     * 判断是否会下溢
     * @param cs
     * @return
     */
    public boolean isUnderFlow(Character[] cs){
        int size = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '-'){
                size --;
            }else {
                size ++;
            }
            if(size < 0){
                return false;
            }
        }
        return true;
    }

    public Character[] generated(Character[] cs){
        Character[] results = new Character[cs.length *2];
        Stack<Character> stack = new Stack<>();
        int pos = 0;
        int j = 0;
        for(int i=0; i<cs.length; i++){
            for (; j < (int)cs[i]-'0'; j++) {
                stack.push((char)(j+'0'));
                results[pos] = (char)(j+'0');
            }
            Character check = stack.pop();
            results[pos] = '-';
            pos ++;
            if (check != cs[i]){
                return null;
            }
        }

        return results;
    }


    public static void main(String[] args) {
        StackGenerability stackGenerability = new StackGenerability();
        Character[] c = new Character[]{'3','-','-'};
        boolean ifUnderFlow = stackGenerability.isUnderFlow(c);
        System.out.println("ifUnderFlow: " + ifUnderFlow);

        Character[] c2 = new Character[]{'3','4','-'};
        boolean answer2 = stackGenerability.isUnderFlow(c2);
        System.out.println("answer2: " + answer2);


    }

    private void changeIntandChar(){

        char c = '1';
        // '-': -3,
        int i =(int)(c-'0');
        System.out.println(i);
        int j = 0;
        char c2 = (char)(i+'0');
        System.out.println(c2);

    }
}

