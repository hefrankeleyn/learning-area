package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe39;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Date 2019-04-18
 * @Author lifei
 */
public class ArrayRingBuffer<Item> implements Iterable<Item>{



    private Item[] a;
    private int N;
    private int index;
    public ArrayRingBuffer(){
        a = (Item[]) new Object[5];
    }
    public ArrayRingBuffer(int length){
        a = (Item[]) new Object[length];
    }

    public int size(){
        return N;
    }

    public void add(Item item){
        if(N == a.length) throw new NoSuchElementException("container full");
        a[N++] = item;
    }

    public Item pop(){
        if(N == 0) throw new NoSuchElementException("overflow");
        Item item = a[index];
        index ++;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<Item>{

        private int endIndex = index + N ;
        private int i = index;
        @Override
        public boolean hasNext() {
            return i < endIndex;
        }

        @Override
        public Item next() {
            Item item = a[i];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ArrayRingBuffer<String> arrayRingBuffer = new ArrayRingBuffer<>();
        arrayRingBuffer.add("aaa");
        arrayRingBuffer.add("bbb");
        arrayRingBuffer.add("ccc");
        System.out.println("size:" + arrayRingBuffer.size());
        String d = arrayRingBuffer.pop();
        System.out.println("delete: " + d);
        System.out.println("size:" + arrayRingBuffer.size());
        for (String s:
             arrayRingBuffer) {
            System.out.println(s);
        }

    }
}
