package com.hef.basepro;

import java.util.BitSet;

/**
 * BitSetTest
 */
public class BitSetTest {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        BitSet bucketOfBits = new BitSet();
        bucketOfBits.set(0);
        bucketOfBits.clear(0);
        System.out.println(bucketOfBits.length());
        System.out.println(bucketOfBits.get(5));
    }
}