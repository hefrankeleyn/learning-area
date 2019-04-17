package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe38;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
public class LinkedListGeneralizedQueue<Item> implements GeneralizedQueue<Item>,Iterable<Item>{

    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void insert(Item x) {
        Node oldFirst = first;
        first = new Node();
        first.item = x;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Item delete(int k) {
        if(k>N || k<=0) throw new NoSuchElementException("overflow");
        Node current = first;
        Node before = first;
        for (int i = 1; i < k; i++) {
            before = current;
            current = current.next;
        }
        Item item = current.item;
        if(N == 1) {
            first = null;
            before = first;
        }else{
            before.next = current.next;
            current = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListGeneralizedQueueIterator();
    }

    private class LinkedListGeneralizedQueueIterator implements Iterator<Item>{

        private Node current;

        public LinkedListGeneralizedQueueIterator(){
            this.current = first;
        }

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
        LinkedListGeneralizedQueue<String> q = new LinkedListGeneralizedQueue<>();
        q.insert("aaa");
        q.insert("bbb");
        q.insert("ccc");
        q.insert("ddd");
        q.insert("eee");
        String d = q.delete(3);
        System.out.println("delete: " + d);
        for (String s:
             q) {
            System.out.println(s);
        }
    }
}
