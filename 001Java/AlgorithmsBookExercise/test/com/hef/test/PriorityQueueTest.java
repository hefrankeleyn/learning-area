package com.hef.test;

import com.hef.algorithms.utils.PriorityQueue;
import org.junit.Test;

/**
 * @Date 2019/10/20
 * @Author lifei
 */
public class PriorityQueueTest {

    @Test
    public void test01(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(23);
        pq.insert(76);
        pq.insert(23);
        pq.insert(45);
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
