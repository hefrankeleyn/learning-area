package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe46;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Date 2019-04-25
 * @Author lifei
 */
public class CircleLink<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public void push(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(N == 0){
            last.next = last;
            first = last;
        }else {
            last.next = first;
            oldLast.next = last;
        }
        N++;
    }

    public Item pop(){
        if(N==0) throw new NoSuchElementException("no element");
        Item item = last.item;
        Node oldNode = last;
        if(N == 1){
            first = null;
            last = null;
        }else{
            Node current = first;
            while (current.next != last){
                current = current.next;
            }
            current.next = first;
            oldNode = null;
        }
        N --;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CatenableOperationIterator();
    }

    private class CatenableOperationIterator implements Iterator<Item>{

        private Node current = first;
        private int i = 0;
        @Override
        public boolean hasNext() {
            return !(current==first && i==1);
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            if(current == first){
                i++;
            }
            return item;
        }
    }

    public static void main(String[] args) {
        CircleLink<String> cl = new CircleLink<>();
        cl.push("aaa");
        cl.push("bbb");
        cl.push("ccc");

        for (String s :
                cl) {
            System.out.println(s);
        }
    }
}
