package com.hef.test;

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
}
