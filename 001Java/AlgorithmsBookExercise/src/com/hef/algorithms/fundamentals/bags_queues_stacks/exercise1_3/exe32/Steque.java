package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe32;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.32 A stack-ended queue or steque is a data-type that supports push, pop, and enqueue.
 * Articulate an API for this ADT. Develop a linked-list-based implements
 */
public class Steque<Item> implements Iterable<Item>{

    private Node first;
    private Node end;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (N==0){
            end = first;
        }
        N++;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = first.item;
        Node oldFirst = first;
        first = oldFirst.next;
        oldFirst.next = null;
        if(size() == 1){
            end = first;
        }
        N--;
        return item;
    }

    public void enqueue(Item item){

        Node oldEnd = end;
        end = new Node();
        end.item = item;
        if(size() ==0){
            first = end;
        }else{
            oldEnd.next = end;
        }
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item>{

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
        Steque<String> stq = new Steque<>();

        stq.push("aaa");
        stq.push("bbb");
        stq.enqueue("ccc");
        String p = stq.pop();
        System.out.println("pop: " + p);

        for (String s:
             stq) {
            System.out.println(s);
        }

    }
}
