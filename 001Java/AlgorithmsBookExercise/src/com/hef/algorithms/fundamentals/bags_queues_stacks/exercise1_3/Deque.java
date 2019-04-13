package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import java.util.Iterator;

/**
 * 1.3.33 Write a class Deque that uses a doubly-linked list to implement this API and a class
 * ResizingArrayDeque that uses a resizing array.
 */
public class Deque<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    public Deque() {
        N = 0;
    }

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    /**
     * is the deque empty
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * number of items in the deque
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * add an item to the left end
     * @param item
     */
    public void pushLeft(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if(isEmpty()){
            last = first;
        }else{
            oldFirst.prev = first;
        }
        N++;
    }

    /**
     * add an item to the right end
     * @param item
     */
    public void pushRight(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        if (N == 0){
            first = last;
        }else{
            oldLast.next = last;
        }
        N++;
    }

    /**
     * remove an item from the left end
     * @return
     */
    public Item popLeft(){
        Item item = first.item;
        Node oldFirst = first;
        first = oldFirst.next;
        first.prev = null;
        if(size() == 1){
            last = first;
        }
        oldFirst.prev = null;
        oldFirst.next = null;
        N --;
        return item;
    }

    /**
     * remove an item from the right end
     * @return
     */
    public Item popRight(){
        Item item = last.item;
        Node oldlast = last;
        last = oldlast.prev;
        last.next = null;
        if (size() == 1){
            first = last;
        }
        oldlast.prev = null;
        oldlast.next = null;
        N --;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushLeft("aaa");
        deque.pushRight("bbb");
        deque.pushLeft("ccc");

        String l = deque.popLeft();
        System.out.println("popLeft: " + l);
        String r = deque.popRight();
        System.out.println("popRight: " + r);
        for (String s:
             deque) {
            System.out.println(s);
        }

        System.out.println("Size: " + deque.size());
    }

}
