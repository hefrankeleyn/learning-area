package com.hef.algorithms.fundamentals.bags_queues_stacks;

import java.util.Iterator;

/**
 * FILO   first in last out
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item>{

    // first node in list
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {

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


}
