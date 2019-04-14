package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe34;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


/**
 * @param <Item>
 * @description 1.3.34 Random bag. A random bag stores a collection of items and supports the following API:
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag, except for
 * the adjective random, which indicates that the iteration should provide the items in random order(N! permutations
 * equally likely, for each iterator). Hint: Put the items in an array and randomize their order in the iterator's
 * constructor.
 * @Date 2019-04-14 09:36
 * @Author lifei
 */
public class RandomBag<Item> implements Iterable<Item> {

    // first node in list
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public RandomBag() {
    }

    /**
     * is the queue empty?
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * number of items in the bag
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * add an item
     * @param item
     */
    public void add(Item item){
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>{

        private Item[] a;
        private int ai;

        public RandomBagIterator() {
            ai = 0;
            Node current = first;
            this.a = (Item[]) new Object[size()];
            int len = size();
            int[] indexs = new int[len];
            for (int i = 0; i < len; i++) {
                indexs[i] = i;
            }
            while (current!=null){
                Random random = new Random();
                int r = random.nextInt(len);
                a[indexs[r]] = current.item;
                current = current.next;
                len -= 1;
                int[] oldIndexs = indexs;
                indexs = new int[len];
                for (int i = 0, j=0; i < oldIndexs.length; i++) {
                    if(i == r) {
                        continue;
                    }
                    indexs[j] = oldIndexs[i];
                    j++;
                }
            }
            System.out.println("a: " + Arrays.toString(a));
        }

        @Override
        public boolean hasNext() {
            return ai < a.length;
        }

        @Override
        public Item next() {
            Item item = a[ai];
            ai ++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<String> randomBag = new RandomBag<>();
        randomBag.add("aaa");
        randomBag.add("bbb");
        randomBag.add("c");
        randomBag.add("d");

        for (String s:
             randomBag) {
            System.out.println(s);
        }
    }
}
