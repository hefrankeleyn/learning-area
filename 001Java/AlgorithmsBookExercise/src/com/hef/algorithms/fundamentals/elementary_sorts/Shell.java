package com.hef.algorithms.fundamentals.elementary_sorts;

import java.util.Arrays;

/**
 * shellsort 希尔排序
 *
 * @Date 2019-06-26
 * @Author lifei
 */
public class Shell extends SortCommont {


    @Override
    public void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        // (3^k -1)/2
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h]...
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private void sort2(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        // (3^k -1)/2
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort the array
            System.out.println("h: " + h);
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h]...
                System.out.println("i:" + i);
                for (int j = i; j >= h; j -= h) {

                    System.out.print("(j:" + j + ",j-h:" + (j - h) + "), ");
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
                System.out.println();
            }
            h = h / 3;
        }
    }
}
