package com.hef.algorithms.fundamentals.elementary_sorts;

/**
 * @Date 2019-06-19
 * @Author lifei
 */
public abstract class SortCommont {

    public abstract void sort(Comparable[] a);

    /**
     * 比较大小
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换元素
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for (Comparable comparable :
                a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public void testSort(String[] a){
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
