package com.hef.test;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Queue;
import org.junit.Test;

import java.util.Random;

public class MathTest {

    @Test
    public void testPow(){
        double r = Math.pow(2, 3);
        System.out.println(r);
        double r1 = Math.sqrt(9);
        System.out.println(r1);
    }

    @Test
    public void randomTest(){
        int len = 9;
        Random random = new Random();
        int i = random.nextInt(len);

        System.out.println("i: " + i);
    }

    @Test
    public void ququeTest(){
        Queue<String> myQueue = new Queue<>();
        System.out.println(myQueue.size());
        myQueue.enqueue("aaa");
        myQueue.enqueue("bbb");
        String q01 = myQueue.dequeue();
        System.out.println(q01);
        String q02 = myQueue.dequeue();
        System.out.println(q02);
        String q03 = myQueue.dequeue();
        System.out.println(q03);
        System.out.println(myQueue.size());

    }
}
