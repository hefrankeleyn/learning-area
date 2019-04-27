package com.hef.algorithms.fundamentals.bags_queues_stacks;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{

    // top of stack (most recently added node)
    private Node first;
    // number of items
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item){
        // Add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N ++;
    }

    public boolean hasNext(){
        return N > 0;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        // Remove item from top of stack
        Item item = first.item;
        first = first.next;
        N --;
        return item;
    }

    public Item peek(){
        if (first == null){
            throw new NoSuchElementException("Stack underflow");
        }else {
            return first.item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private int totalSize = N;
        private Node current = first;

        @Override
        public boolean hasNext() {
            if (totalSize == N){
                return current != null;
            }else{
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public Item next() {
            if(totalSize == N){
                Item item = current.item;
                current = current.next;
                return item;
            }else {
                throw new ConcurrentModificationException();
            }

        }
    }



    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("size: " + stack.size());
        System.out.println(stack.pop());
        Stack<String>[] stacks = (Stack<String>[]) new Stack[5];
    }
}
