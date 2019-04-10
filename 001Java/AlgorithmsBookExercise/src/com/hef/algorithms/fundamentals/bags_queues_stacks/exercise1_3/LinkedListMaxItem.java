package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

/**
 * 1.3.27 Develop a recursive solution to the previous question:
 *
 * 1.3.26 Write a method max() that takes a reference to the first node in a linked list as argument and return the value
 * of the maximum key in the list. Assume that all keys are positive integers, and return 0 if the list is empty.
 */
public class LinkedListMaxItem {

    public static int max(Node first){
        if(first == null) return 0;
        if(first.item > max(first.next)) return first.item;
        else return max(first.next);
    }

    public static void main(String[] args) {
        Node one = new Node();
        one.item = 1;
        Node two = new Node();
        two.item = 9;
        one.next = two;
        Node three = new Node();
        three.item = 5;
        two.next = three;
        int max = max(one);

        System.out.println(max);
    }
}


class Node{
    Integer item;
    Node next;
}

