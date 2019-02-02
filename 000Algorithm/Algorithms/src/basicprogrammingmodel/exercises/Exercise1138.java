package basicprogrammingmodel.exercises;

import java.util.Arrays;

import utils.chapter1.In;
import utils.chapter1.StdIn;

/**
 * Exercise1138
 */
public class Exercise1138 {

    public static void main(String[] args) {
        String largWFile = args[0];
        In in = new In(largWFile);
        int[] writeNumbers = in.readAllInts();
        Arrays.sort(writeNumbers);
        long start = System.currentTimeMillis();
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            runBruteForceSearchTest(key, writeNumbers);
            //82619 ms
            runBinarySearch(key, writeNumbers);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");

    }

    public static void runBruteForceSearchTest(int key, int[] a){
        int i = BruteForceSearch.rank(key, a);
        if (i > 0)
            System.out.println(a[i]);
    }

    public static void runBinarySearch(int key, int[] a){
        int i = BinarySearch.rank(key, a);
        if (i>0)
            System.out.println(a[i]);
            
    }
}