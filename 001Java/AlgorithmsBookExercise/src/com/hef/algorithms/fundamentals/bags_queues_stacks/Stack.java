package com.hef.algorithms.fundamentals.bags_queues_stacks;

import java.util.Iterator;

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

    public Item pop(){
        // Remove item from top of stack
        Item item = first.item;
        first = first.next;
        N --;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

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
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("size: " + stack.size());
        System.out.println(stack.pop());
        Stack<String>[] stacks = (Stack<String>[]) new Stack[5];
    }
}
