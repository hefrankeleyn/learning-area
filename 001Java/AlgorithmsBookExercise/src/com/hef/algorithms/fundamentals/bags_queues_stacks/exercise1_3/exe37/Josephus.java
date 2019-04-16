package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe37;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * First In Fist out
 * 1.3.37 N people, they arrange themselves in a circle (at positions unmbered from 0 to N-1) and proceed around the circle,
 * eliminating every Mth peron until only one person is left. Legend has it that Josephus figured out where to sit to avoid
 * being eliminated. Write a Queue client Josephus that takes N and M from command line and prints out the order in which people
 * are eliminated (and thus would show Josephus where to sit in the circle)
 * @Date 2019-04-16
 * @Author lifei
 */
public class Josephus<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    private int numTh;

    public Josephus() {
        this.numTh = 1;
    }

    public Josephus(int numTh) {
        this.numTh = numTh;
    }

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (N==0){
            first = last;
            last.next = last;
        }else{
            oldLast.next = last;
            last.next = first;
        }
        N++;
    }

    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = last.item;
        Node oldLast = last;
        Node before = first;
        while (before.next != oldLast){
            before = before.next;
        }
        if(size() == 1){
            last = null;
            first = null;
        }else{
            last = before;
            last.next = first;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new JosephusIterator();
    }

    private class JosephusIterator implements Iterator<Item>{

        private int r;
        private int total;
        private Node before = last;
        private Node current = first;
        public JosephusIterator(){
            total = size();
        }
        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public Item next() {
            r = numTh % total;
            if(r==0){
                r=total;
            }
//            Node before = last;
            for(int i=0; i< r-1; i++){
                before = current;
                current = current.next;
            }
            Item item = current.item;
            if(before == current){
                current = null;
                before = null;
            }else {
                current = current.next;
                before.next = current;
            }
            total --;
            return item;
        }
    }


    public static void main(String[] args) {
        int M = 7;
        int N = 2;
        Josephus<Integer> josephus = new Josephus<>(N);
        for (int i = 0; i < M; i++) {
            josephus.enqueue(i);
        }
        for(Integer res: josephus){
            System.out.print(res + " ");
        }
    }
}
