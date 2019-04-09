package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Queue;
import com.hef.commons.In;

public class QueueExtends {

    public static Date[] readDates(String s){
        In in = new In(s);
        Queue<Date> q = new Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(new Date(in.readString()));
        }

        int N = q.size();
        Date[] a = new Date[N];
        for (int i=0; i < N; i++){
            a[i] = q.dequeue();
        }
        return a;
    }
}
