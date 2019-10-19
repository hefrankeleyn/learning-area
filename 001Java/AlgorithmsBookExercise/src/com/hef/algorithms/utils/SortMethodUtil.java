package com.hef.algorithms.utils;

/**
 * @Date 2019/10/19
 * @Author lifei
 */
public class SortMethodUtil {

    private static Comparable[] aux;

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

    /**
     * 自顶向下归并排序
     * @param a
     */
    public static void topBottomMergeSort(Comparable[] a){
        aux = new Comparable[a.length];
        topBottomMergeSort(a, 0, a.length-1);
    }

    private static void topBottomMergeSort(Comparable[] a, int lo, int hi){
        if (lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        topBottomMergeSort(a, lo, mid);
        topBottomMergeSort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 自顶向下的归并排序
     * @param a
     */
    public static void bottomToTopMergeSort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int i = 0; i < N; i++) {
            aux[i] = a[i];
        }
        for (int sz=1; sz<N; sz = sz+sz){
            for (int i = 0; i < N - sz; i+=sz+sz) {
                merge(a, i, i+sz-1, Math.min(i+sz+sz-1, a.length-1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        int x =lo, y= mid + 1;
        for (int i = lo; i<=hi; i++){
            aux[i] = a[i];
        }
        for (int j= lo; j<=hi; j++){
            if (x>mid) a[j] = aux[y++];
            else if (y>hi) a[j] = aux[x++];
            else if (less(aux[x], aux[y])) a[j] = aux[x++];
            else a[j] = aux[y++];
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
