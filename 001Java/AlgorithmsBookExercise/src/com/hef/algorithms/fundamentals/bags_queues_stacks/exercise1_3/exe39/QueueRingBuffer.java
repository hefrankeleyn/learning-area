package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe39;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.39 Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed size N. It is useful transferring
 * data between asynchronous processes or for storing log files. When the buffer is empty, the consumer waits until data
 * is deposited; when the buffer is full, the producer waits to deposit data. Develop an API for a QueueRingBuffer and an
 * implementation that uses an array representation(with circular wrap-around)
 * @Date 2019-04-18
 * @Author lifei
 */
public class QueueRingBuffer<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;
    private int len;

    class Node{
        Item item;
        Node next;
    }

    public QueueRingBuffer(){
        len = 5;
    }

    public QueueRingBuffer(int length) {
        len = length;
    }

    public void add(Item item){
        if(N == len) throw new NoSuchElementException("container is full");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(N == 0){
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;

    }

    public Item delete(){
        if(N==0) throw new NoSuchElementException("overflow");
        Item item = first.item;
        Node oldFirst = first;
        first = oldFirst.next;
        oldFirst = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RingBufferIterator();
    }

    private class RingBufferIterator implements Iterator<Item>{

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

        QueueRingBuffer<String> rb = new QueueRingBuffer<>();
        rb.add("aaa");
        rb.add("bbb");
        rb.add("ccc");

        String d = rb.delete();
        System.out.println("delete: " + d);
        for (String s:
             rb) {
            System.out.println(s);
        }
    }
}
