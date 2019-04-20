package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe40;

import java.util.Iterator;
import java.util.Objects;

/**
 * 1.3.40 Move-to-front. Read in a sequence of characters from standard input and maintain the characters in a linked
 * list with no duplicates. When you read in a previously unseen character, insert it at the front of the list. when you
 * read in a duplicate character, delete it from the list and reinsert it at the beginning. Name your proggram MoveToFront:
 * it implements the well-know move-to-front strategy, which is useful for caching, data compression, and many other
 * applications where items that have been recently accessed are more likely to be reaccessed.
 * @Date 2019-04-19
 * @Author lifei
 */
public class MoveToFront<Item> implements Iterable<Item>{

    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public void insert(Item item){
        // delete special item
        deleteItem(item);
        // add item on before
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }


    public int size(){
        return N;
    }

    private void deleteItem(Item item){
        Node current = first;
        Node before = first;
        while (current!=null){
            if(Objects.equals(current.item, item)){
                if(current == before){
                    Node oldFirst = first;
                    first = oldFirst.next;
                    oldFirst = null;
                }else {
                    before.next = current.next;
                }
                N --;
            }
            before = current;
            current = current.next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new MoveToFrontIterator();
    }

    private class MoveToFrontIterator implements Iterator<Item>{

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

    public static void main(String[] args) {
        MoveToFront<Character> q = new MoveToFront<>();
        q.insert('a');
        q.insert('b');
        q.insert('c');
        q.insert('b');
        q.insert('a');

        for (char s:
                q) {
            System.out.println(s);
        }

        System.out.println("***********");
        MoveToFront<String> qs = new MoveToFront<>();
        qs.insert("aaa");
        qs.insert("bb");
        qs.insert("cc");
        qs.insert("aaa");
        qs.insert("aaa");
        printQs(qs);


    }

    public static void printQs(MoveToFront<String> qs){
        for (String ss:
                qs) {
            System.out.println(ss);
        }
    }
}
