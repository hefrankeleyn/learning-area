package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe42;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.42 Copy a stack. Create a new constructor for the linked-list implementation of Stack so that
 * Stack<Item> t = new Stack</Item>();   make a reference to a new and independent copy of the stack s.
 * @Date 2019-04-22
 * @Author lifei
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public Stack() {
    }

    public Stack(Stack<Item> q){
        Stack<Item> tempStack = new Stack<>();
        for (Item item :
                q) {
            tempStack.push(item);
        }

        for (Item i :
                tempStack) {
            push(i);
        }
    }
    public int size(){
        return N;
    }


    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N ++;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = first.item;
        Node oldFirst = first;
        first = oldFirst.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        String d = stack.pop();
        System.out.println("delete: " + d);
        pStack(stack);

        Stack<String> r = new Stack<>(stack);
        pStack(r);
        String dr = r.pop();
        System.out.println("dr: " + dr);
        pStack(stack);
        pStack(r);
    }

    public static void pStack(Stack<String> q){
        for (String s:
                q) {
            System.out.println(s);
        }
        System.out.println("*********");
    }
}
