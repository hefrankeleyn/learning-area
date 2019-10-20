package com.hef.algorithms.utils;

import java.util.Random;

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

    public static void quickSort(Comparable[] a){
        if (a==null) return;
        arrayShuffle(a);
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(Comparable[] a, int lo, int hi){
        if (lo>=hi) return;
        int j= partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi){
        Comparable tem = a[0];
        int x=lo+1, y=hi;
        while (x<=y){
            int c = a[x].compareTo(tem);
            if (c<=0){
                x++;
            }else {
                exch(a, x, y--);
            }
        }
        exch(a, lo, y);
        return y;
    }

    private static int partition02(Comparable[] a, int lo, int hi){
        int i=lo, j=hi+1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++lo],v)) if (lo==hi) break;
            while (less(v, a[--hi])) if (hi==lo) break;
            if (i>=j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void threeWayQuickSort(Comparable[] a){
        if (a == null) return;
        arrayShuffle(a);
        threeWayQuickSort(a, 0, a.length-1);
    }

    private static void threeWayQuickSort(Comparable[] a, int lo, int hi){
        if (lo>=hi) return;
        Comparable tem = a[lo];
        int i = lo+1, j = hi, mid =lo;
        while (i<=j){
            int c = a[i].compareTo(tem);
            if (c<0) exch(a, i++, mid++);
            else if(c>0) exch(a, i, j--);
            else i++;
        }
        threeWayQuickSort(a, lo, mid-1);
        threeWayQuickSort(a, j+1, hi);
    }

    public static void heapSort(Comparable[] a){
        if (a == null) return;
        int N = a.length-1;
        for (int i=N/2; i>=0; i--){
            sink(a, i, N);
        }
        while (N>0){
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    /**
     * begin from 0
     * @param a
     * @param i
     * @param N max index
     */
    private static void sink(Comparable[] a, int i, int N){
        while (i*2+1<N){
            int j= i*2 + 1;
            if (j+1<N && less(a[j], a[j+1])) j = j+1;
            if (less(a[j], a[i])) break;
            exch(a, j, i);
            i = j;
        }
    }

    /**
     * index begin from 0
     * @param a
     * @param i
     */
    public static void swim(Comparable[] a, int i){
        while (i>0 && less(a[(i+1)/2-1], a[i])){
            exch(a, (i+1)/2-1, i);
            i = (i+1)/2-1;
        }
    }

    public static void arrayShuffle(Comparable[] a){
        if (a == null) return;
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int s = random.nextInt(a.length-i);
            exch(a, i, s);
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
