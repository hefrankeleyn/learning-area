package com.hef.marco.service;

import org.junit.Test;

import java.util.Random;

/**
 * @Date 2019-05-01
 * @Author lifei
 */
public class RandomTest {

    @Test
    public void test01(){
        int size = 10;
        Random random = new Random();
        int i = random.nextInt(size);
        System.out.println("i:" + i);
    }
}
