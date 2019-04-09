package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Queue;
import com.hef.commons.StdIn;

/**
 * Write a Queue client that takes a command-line argument k and prints the kth from the last string found on standard input
 * (assuming that standard input has k or more strings.)
 */
public class QueueKthStr {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals(":q")){
                break;
            }else {
                queue.enqueue(s);
            }
        }
        int size = queue.size();

        int k = (int) (Math.random() * size);

        int f = size - k + 1;
        int t = 1;
        System.out.println("k:" + k);
        for(String rs : queue){
            if (t == f){
                System.out.println("kth: " + rs);
                break;
            }
            t ++;
        }
    }
}
