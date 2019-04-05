package com.hef.algorithms.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * FIFO
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item>{

    // link to least recently added node
    private Node first;
    // link to most recently added node
    private Node last;
    // number of items on the queue
    private int N;

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(Item item){
        // Add item to the end of the list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N ++;
    }

    public Item dequeue(){
        // Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

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
        Queue<String> queue = new Queue<>();
        queue.dequeue();
    }
}
