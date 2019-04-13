package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

public class LinkedListTest {

    /**
     * Write a function that takes the first Node in the linked list
     * as argument and reverse the list, returningg the first Node in the result
     * @param x
     * @return
     */
    public Node reverse(Node x){
        Node first = x;
        Node reverse = null;
        while (first != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    /**
     * Recurive solution: Assuming the linked list has N nodes, we recursively
     * reverse the last N-1 nodes, and than carefully append the first node to
     * end.
     * @param first
     * @return
     */
    public Node reverseRecursively(Node first){
        if (first== null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }
}


