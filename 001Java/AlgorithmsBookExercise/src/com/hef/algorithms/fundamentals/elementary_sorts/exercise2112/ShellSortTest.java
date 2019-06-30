package com.hef.algorithms.fundamentals.elementary_sorts.exercise2112;

import com.hef.algorithms.fundamentals.elementary_sorts.SortCommont;

import java.math.BigDecimal;

/**
 * @Date 2019-06-30
 * @Author lifei
 */
public class ShellSortTest {

    public static void main(String[] args) {
        int l = 10;

        testSortDoubleArray(100);
        testSortDoubleArray(1000);
        testSortDoubleArray(10000);
        testSortDoubleArray(100000);
        testSortDoubleArray(1000000);
    }

    private static void testSortDoubleArray(int size){
        Double[] a = new Double[size];
        for (int j = 0; j < a.length; j++) {
            double random = Math.random() * 100;
            a[j] = pointTwoIndex(random);
        }

        ShellSort shellSort = new ShellSort();
        shellSort.sort(a);
    }

    /**
     * 保留两位小数
     *
     * @param random
     * @return
     */
    private static double pointTwoIndex(double random) {
        BigDecimal bigDecimal = new BigDecimal(random);
        double v = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return v;
    }


}

class ShellSort extends SortCommont {

    @Override
    public void sort(Comparable[] a) {
        int count = 0;
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                ok:
                for (int j = i; j >= h; j -= h) {
                    count++;
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    } else {
                        break ok;
                    }
                }
            }
            h = h / 3;
        }

        System.out.println("count: " + count);
        System.out.println("length: " + a.length);
        System.out.println(count/a.length);

        for (int i = 0;i<5; i++){
            System.out.print(a[i] + ",");
        }
    }
}
