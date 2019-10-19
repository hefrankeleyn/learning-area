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

    public static void insertionSort(Comparable[] a){
        if (a == null) return;
        for (int i=1; i<a.length; i++){
            for (int j=i; j>=1 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }

    public static void shellSort(Comparable[] a){
        if (a == null) return;
        int N = a.length;
        int s = 1;
        while (s<N) s = s * 3 + 1;
        while (s>=1){
            for (int i = s; i < N; i += s) {
                for (int j=i; j>=s && less(a[j], a[j-s]); j--){
                    exch(a, j, j-s);
                }
            }
            s = s/3;
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
