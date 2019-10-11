package com.hef.algorithms.fundamentals.mergesort;

import com.hef.algorithms.fundamentals.elementary_sorts.SortCommont;

/**
 * @Date 2019-07-05
 * @Author lifei
 */
public class MergeBU extends SortCommont {


    private static Comparable[] aux;


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
