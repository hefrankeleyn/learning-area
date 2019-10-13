package com.hef.basepro;

import java.util.BitSet;

/**
 * 统计素数的个数
 */
public class Sieve {

    public static void main(String[] args) {
        Sieve sieve = new Sieve();
        int n = 200_0000;
        n = 100;
        sieve.countPrime(n);
    }

    /**
     * 利用位集统计素数
     * 思路： 首先将所有的位置设置为“开”状态，然后，将已知素数的倍数所对应的位都设置为“关”状态。
     * 经过这个操作，保留下来的位对应的就是素数
     * @param n
     */
    public void countPrime(int n){
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n+1);
        int count = 0;
        int i;
        for (i=2; i<= n; i++){
            b.set(i);
        }
        i = 2;
        while(i*i<n){
            if(b.get(i)){
                System.out.print(" "+i);
                count ++;
                int k = i + i;
                while (k<=n){
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while(i<=n){
            if(b.get(i)) {
                System.out.print(" "+i);
                count++;
            }
            i++;
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end-start) + " milliseconds");
    }
}