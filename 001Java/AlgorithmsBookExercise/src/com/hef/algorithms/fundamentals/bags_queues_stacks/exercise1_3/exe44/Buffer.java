package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe44;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;

import java.util.NoSuchElementException;

/**
 * 1.3.44 Text editor buffer. Develop a data type for a buffer in a text editor that implements the following API
 * Hint: Use two stacks
 * @Date 2019-04-23
 * @Author lifei
 */
public class Buffer {

    private Stack<Character> stack = new Stack<>();

    /**
     * Create a empty buffer
     */
    public Buffer() {
    }

    /**
     * insert c at the cursor position
     * @param c
     */
    public void insert(char c){
        stack.push(c);
    }

    /**
     * delte and return the character at the cursor
     * @return
     */
    public char delete(){
        return stack.pop();
    }

    /**
     * move the cursor k positions to the left
     * @param k
     */
    public void left(int k){
        if(k<=0 || k>size()) throw new NoSuchElementException("overflow");
        Stack<Character> tempStack = new Stack<>();
        char temp = 'a';
        int len = stack.size();
        for (int i=1; i<=len; i++) {
            char tc = stack.pop();
            if(i == k){
                temp = tc;
            }else {
                tempStack.push(tc);
            }
        }
        stack.push(temp);
        len = tempStack.size();
        for (int j=0; j<len; j++) {
            stack.push(tempStack.pop());
        }

    }

    /**
     * move the cursor k positions to the right
     * @param k
     */
    public void right(int k){
        if(k<=0 || k>size()) throw new NoSuchElementException("overflow");
        Stack<Character> tempStack = new Stack<>();
        Character temp = null;
        int len = stack.size();
        for (int i=1; i<=len; i++) {
            if(i == k){
                temp = stack.pop();
            }else {
                tempStack.push(stack.pop());
            }
        }
        len = tempStack.size();
        for (int j=0; j<len; j++) {
            stack.push(tempStack.pop());
        }
        stack.push(temp);

    }

    private void loopStack(Stack<Character> stack){
        String result = "";
        for (Character c :
                stack) {
            System.out.printf("%s%s",c," ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String result = "";
        for (Character c :
                stack) {
            result += c + " ";
        }
        return result;
    }

    /**
     * number of character in the buffer
     * @return
     */
    public int size(){
        return stack.size();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');

        System.out.println(buffer.toString());

        buffer.left(2);
        System.out.println(buffer.delete());

        System.out.println(buffer.toString());
    }


}
