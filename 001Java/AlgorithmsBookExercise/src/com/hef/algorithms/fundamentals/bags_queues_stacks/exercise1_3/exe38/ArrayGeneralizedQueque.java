package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe38;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
public class ArrayGeneralizedQueque<Item> implements GeneralizedQueue<Item>,Iterable<Item>{


    private Item[] a;
    private int N;
    public ArrayGeneralizedQueque(){
        a = (Item[]) new Object[2];
        N = 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int len){
        assert len > N;
        Item[] items = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            items[i] = a[i];
        }
        a = items;
    }

    @Override
    public void insert(Item x) {
        if(N == a.length) resize(N * 2);
        a[N] = x;
        N++;
    }

    /**
     * delete and return the kth least recently inserted item
     * @param k
     * @return
     */
    @Override
    public Item delete(int k) {
        if(k>N) throw new NoSuchElementException("overflow");
        int index = N - k;
        Item item = a[index];
        Item[] items = (Item[]) new Object[N-1];
        for (int i = 0, j=0; i < N; i++) {
            if(i == index){
                continue;
            }
            items[j] = a[i];
            j ++;
        }
        a = items;
        N--;
        if(N == a.length/4) resize(N / 2);
        return item;
    }

    public static void main(String[] args) {
        ArrayGeneralizedQueque<String> q = new ArrayGeneralizedQueque<>();
        q.insert("aaa");
        q.insert("bbb");
        q.insert("ccc");
        q.insert("ddd");
        String d = q.delete(2);
        System.out.println("delete: " + d);
        for (String s:
             q) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayGeneralizedQueueIterator();
    }

    private class ArrayGeneralizedQueueIterator implements Iterator<Item>{

        private int i;
        private int len = N;

        public ArrayGeneralizedQueueIterator() {
            this.i = len-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            Item item = a[i];
            i--;
            return item;
        }
    }
}
