package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe41;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue: FIFO   first in first out.
 * 1.3.41 Copy a queue. Create a new constructor so that Queue<Item> r = new Queue</Item>(); make r a reference
 * to new and independent copy of the queue q. You should be able to push and pop from either q or r without
 * influencing the other. Hint: Delete all of the elements from q and add these elements to both q and r
 * @Date 2019-04-21
 * @Author lifei
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public Queue() {
    }

    public Queue(Queue<Item> q){
        for (int i = 0; i < q.size(); i++) {
            Item temI = q.pop();
            q.push(temI);
            this.push(temI);
            N++;
        }
    }



    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;

        if(N == 0){
            first = last;
        }else {
            oldlast.next = last;
        }
        N++;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = first.item;
        Node oldFirst = first;
        first = oldFirst.next;
        oldFirst = null;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{

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
        Queue<String> q = new Queue<>();
        q.push("aa");
        q.push("bb");
        q.push("cc");
        String d = q.pop();
        System.out.println("delete: " + d);
        showQ(q);
        System.out.println("***************");
        Queue<String> r = new Queue<>(q);
        showQ(r);

    }

    public static void showQ(Queue<String> q){
        for (String s:
                q) {
            System.out.println(s);
        }
    }
}
