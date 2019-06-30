package com.hef.algorithms.fundamentals.elementary_sorts;

/**
 * 插入排序
 * @Date 2019-06-19
 * @Author lifei
 */
public class Insertion extends SortCommont{
    /**
     * 插入排序
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        // Sort a[] into inCreasing order
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3].....
            for (int j = i; j >0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
