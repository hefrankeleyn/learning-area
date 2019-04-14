package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe33;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <Item>
 */
public class ResizingArrayDeque<Item> implements Iterable<Item>{

    // The size of ResizingArrayDeque
    private int N;
    private Item[] a;
    public ResizingArrayDeque() {
        a = (Item[]) new Object[2];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    /**
     * resize array
     * @param len
     */
    private void resize(int len){
        assert len >= N;
        Item[] items = (Item[]) new Object[len];
        for (int i = 0; i < size(); i++) {
            items[i] = a[i];
        }
        a = items;
    }

    /**
     * is the resizingArrayDeque empty?
     * @param item
     */
    public void pushLeft(Item item){
        if(N == a.length) resize(a.length * 2);
        Item[] newA = (Item[]) new Object[a.length];
        newA[0] = item;
        for (int i = 0; i < size(); i++) {
            newA[i+1] = a[i];
        }
        a = newA;
        N++;
    }

    public void pushRight(Item item){
        if(N==a.length) resize(a.length * 2);
        a[N] = item;
        N ++;
    }

    public Item popLeft(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = a[0];
        Item[] newA = (Item[]) new Object[a.length];
        for (int i = 1; i < size(); i++) {
            newA[i-1] = a[i];
        }
        a = newA;
        N--;
        if(size() == a.length/4) resize(a.length / 2);
        return item;
    }

    public Item popRight(){
        if(isEmpty()) throw new NoSuchElementException("overflow");
        Item item = a[N-1];
        a[N-1] = null;
        N--;
        if(size() == a.length/4) resize(a.length / 2);
        return item;
    }



    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<Item> {

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Item next() {
            Item item = a[current];
            current += 1;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> ra = new ResizingArrayDeque<>();
        ra.pushLeft("aaa");
        ra.pushRight("bbb");
        ra.pushLeft("ccc");
        String p1 = ra.popLeft();
        System.out.println("p1: " + p1);
        String p2 = ra.popRight();
        System.out.println("p2: " + p2);

        for (String s:
             ra) {
            System.out.println(s);
        }
        System.out.println("size: " + ra.size());
    }
}
