package collections.sieve;

import java.util.BitSet;

/**
 * This program runs the Sieve of Erathostenes benchmark. It computes all primes up to 2000000
 * @version 1.0 2019-01-26
 * @author Li Fei
 */
public class Sieve {

    public static void main(String[] args) {
        //runMain();
        bitSetTest();
    }
    private static void bitSetTest(){
        BitSet b = new BitSet(1);
        System.out.println(b);
        System.out.println(b.get(0));
        b.set(0);
        System.out.println(b);
        System.out.println(b.get(0));
    }
    /**
     * calculate all sieve between 2 and 2_000_000
     */
    private static void runMain(){
        int n = 2_000_000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n +1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++){
            b.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                count ++;
                int k = 2 * i;
                while (k <= n){
                    b.clear(k);
                    k += i;
                }
            }
            i ++;
        }
        while (i <= n) {
            if (b.get(i)) count ++;
            i ++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}