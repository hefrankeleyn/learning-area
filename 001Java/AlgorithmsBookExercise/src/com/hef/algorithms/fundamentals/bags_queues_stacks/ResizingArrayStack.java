package com.hef.algorithms.fundamentals.bags_queues_stacks;


import java.util.Iterator;

/**
 * this takes time proportional to the size of the stack.
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public ResizingArrayStack(int cap) {
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void  push(Item item){
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N]  = null;
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }


    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(10);
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ddd");
        System.out.println("size: " + stack.size());
        System.out.println(stack.pop());
    }
}
