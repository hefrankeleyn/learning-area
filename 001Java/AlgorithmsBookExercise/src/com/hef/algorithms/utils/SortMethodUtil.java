package com.hef.algorithms.utils;

/**
 * @Date 2019/10/19
 * @Author lifei
 */
public class SortMethodUtil {

    /**
     * 思路：将最小值放到最前面
     * @param a
     */
    public static void selectionSort(Comparable[] a){
        if (a == null) return;

        for (int i=0; i<a.length-1; i++){
            int ti = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j], a[ti])){
                    ti = j;
                }
            }
            exch(a, i, ti);
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable v, Comparable m){
        return v.compareTo(m)<0;
    }
}
