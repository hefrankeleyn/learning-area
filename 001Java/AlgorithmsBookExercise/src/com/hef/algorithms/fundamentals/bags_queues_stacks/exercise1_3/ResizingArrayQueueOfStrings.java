package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {

    // queue elements
    private String[] items;
    // number of elements on queue
    private int n;
    // index of next available of slot
    private int last;
    // index of first element of queue
    private int first;

    public ResizingArrayQueueOfStrings() {
        items = new String[2];
        n = 0;
        first = 0;
        last = 0;
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    /**
     * Adds the item to this queue
     * @param item the item to add
     */
    public void enqueue(String item){
        if(n == items.length) resize(items.length * 2);
        items[last++] = item;
        if (last == item.length()) last = 0;
        n++;

    }

    public String dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        String item = items[first];
        items[first] = null;
        n--;
        if (first == items.length) first = 0;
        if(n>0 && n == items.length/4) resize(items.length/2);
        return item;
    }

    private void resize(int max){
        assert max > n;
        String[] nItems = new String[max];
        for(int j=0 ; j<n; j++){
            nItems[j] = items[(first + j) % items.length];
        }
        items = nItems;
        first = 0;
        last = n;
    }

    public String peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow.");
        return items[first];
    }
}
