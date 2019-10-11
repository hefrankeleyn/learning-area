package com.hef.algorithms.fundamentals.mergesort;

import com.hef.algorithms.fundamentals.elementary_sorts.SortCommont;

/**
 * @Date 2019-07-01
 * @Author lifei
 */
public class MergeSort extends SortCommont {
    @Override
    public void sort(Comparable[] a) {
        merge(a, 0, a.length/2-1,a.length-1);
    }


    /**
     * Top-down mergesort
     * recursive
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        // Sort left half
        sort(a, lo, mid);
        // Sort right half
        sort(a, mid + 1, hi);
        // Merge results
        merge(a, lo, mid, hi);
    }

    /**
     *  原地合并的抽象   Abstract in-place merge
     *  通过复制数组中的每一项到一个副本中，然后再合并到原来的数组中
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        // Merge a[lo..mid] with a[mid+1..hi].
        int i=lo, j= mid+1;
        // Copy a[lo..hi] to aux[lo..hi].
        Comparable[] aux = new Comparable[a.length];
        for (int k=lo; k<=hi;k++){
            aux[k] = a[k];
        }

        // Merge back to a[lo..hi].
        for (int k=lo; k<=hi; k++){
            if (i>mid) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
