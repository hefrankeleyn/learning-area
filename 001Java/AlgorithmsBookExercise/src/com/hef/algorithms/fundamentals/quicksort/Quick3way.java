package com.hef.algorithms.fundamentals.quicksort;

import com.hef.algorithms.fundamentals.elementary_sorts.SortCommont;
import com.hef.commons.StdRandom;

/**
 *
 * @Date 2019-07-20
 * @Author lifei
 */
public class Quick3way extends SortCommont {


    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);

    }

    /**
     * 使用三段式对数据进行排序： 第一段存放的是小于分割值，第二段存放的是等于分割值， 第三段存放的是大于分割值
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[]a, int lo, int hi){
        if (hi<=lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i<=gt){
            int com = a[i].compareTo(v);
            if (com<0) exch(a, lt++, i++);
            else if (com>0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}
