package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FIFO : first in first out
 * 1.3.29 Circluar queue
 * @param <Item>
 */
public class CircularQueue<Item> implements Iterable<Item>{

    // the value of current node
    private Item item;
    // the last node of queue
    private Node last;
    // the length of queue
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    /**
     * queue if none
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
    /**
     *
     * @param item add a item to queue
     */
    public void enqueue(Item item){
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = last;
        }else {
            Node old = last;
            last = new Node();
            last.item = item;
            last.next = old.next;
            old.next = last;
        }
        N ++;
    }

    /**
     * pop first node
     * @return
     */
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("queue outflow.");
        Node first = last.next;
        if(size() == 1){
            first.next = null;
        }else {
            last.next = first.next;
            first.next = null;
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CircularQueueIterator();
    }

    private class CircularQueueIterator implements Iterator<Item>{

        private Node current;

        public CircularQueueIterator() {
            this.current = last.next;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            if (current.next == last){
                current = null;
            }
            return item;
        }
    }


    public static void main(String[] args) {
        CircularQueue<String> q = new CircularQueue<>();
        q.enqueue("aaa");
        q.enqueue("bbb");
        System.out.println("N: " + q.size());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
        for (String s:
             q) {
            System.out.println(s);
        }
    }


}
