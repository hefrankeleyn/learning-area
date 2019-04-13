package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implemented a nested class DoubleNode for building doubly-linked lists,
 * where each node contains a reference to the item preceding it and the item
 * following it in the list (null if there is no such item).
 * Then implement static method for the following tasks:
 *
 * @author lifei
 * @date 2019-04-12
 */
public class DoubleNode<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
        Node before;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
    /**
     * insert at the beginning
     * @param item
     */
    public void insertAtBegining(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        first.before = null;
        if (N == 0) {
            last = first;
        }else{
            oldfirst.before = first;
        }
        N ++;
    }

    /**
     * insert at the end
     * @param item
     */
    public void insertAtEnd(Item item){
        Node oldEnd = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (N == 0){
            first = last;
            last.before = null;
        }else{
            oldEnd.next = last;
            last.before = oldEnd;
        }
        N ++;
    }

    /**
     * remove from the beginning
     * @return
     */
    public Item removeFromBeginning(){
        if(isEmpty()) throw  new NoSuchElementException("item outflow!");
        Item item = first.item;
        Node oldFirst = first;
        first = new Node();
        first = oldFirst.next;
        oldFirst.next = null;
        first.before = null;
        N--;
        if(isEmpty()) last = first;
        return item;
    }

    public Item removeFromEnd() {
        if(isEmpty()) throw new NoSuchElementException("item outflow!");
        Item item = last.item;
        Node oldEnd = last;
        last = new Node();
        last = oldEnd.before;
        last.next = null;
        if(N == 0) {
            first = oldEnd;
        }
        N--;
        return item;
    }

    public void insertBeforOneNode(Item current, Item insert){
       Node c = first;
       while (c!=null){
          Node  n = new Node();
          n.item = insert;
          if(c.item == current) {
              if(c == first || size() == 1){
                  insertAtBegining(insert);
              }else{
                  c.before.next = n;
                  n.before = c.before;
                  n.next = c;
                  c.before = n;
                  N++;
              }
              break;
          }else {
              c = c.next;
          }
       }
    }

    public void insertAfterOneNode(Item current, Item insert) {
        Node c = first;
        while (c!=null){
            Node  n = new Node();
            n.item = insert;
            if(c.item == current) {
                if(c == last || size() == 1){
                    insertAtEnd(insert);
                }else{
                    c.next.before = n;
                    n.next = c.next;
                    n.before = c;
                    c.next = n;
                    N++;
                }
                break;
            }else {
                c = c.next;
            }
        }
    }

    public void deleteOneItem(Item item){
        Node c = first;
        while (c!=null){
            if(c.item == item) {
                if(c == first || size() == 1){
                    removeFromBeginning();
                }else if(c == last){
                    removeFromEnd();
                }else{
                    Node old = c;
                    c.before = c.next;
                    c.next.before = c.before;
                    c.before =null;
                    c.next = null;
                    N--;
                }
                break;
            }else {
                c = c.next;
            }
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleNodeIterator();
    }

    private class DoubleNodeIterator implements Iterator<Item>{

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
        DoubleNode<String> dn = new DoubleNode<>();
        dn.insertAtBegining("aaa");
        dn.insertAtEnd("bbb");
        dn.insertAtBegining("ccc");
        dn.insertAfterOneNode("bbb", "eee");
        dn.insertBeforOneNode("bbb", "fff");
        dn.removeFromEnd();
        dn.removeFromBeginning();


        for (String s:
             dn) {
            System.out.println(s);
        }
        System.out.println("size: " + dn.size());
    }


}
