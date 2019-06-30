package com.hef.algorithms.fundamentals.elementary_sorts;

/**
 * 选择排序
 * @Date 2019-06-19
 * @Author lifei
 */
public class Selection extends SortCommont{

    /**
     * 选择排序，将 最小值移到最前面
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        for (int i=0; i<N; i++){
            int min = i;
            for (int j=i+1; j<N; j++){
                if(less(a[j], a[min])){
                    min = j;
                }
                exch(a, i, min);
            }
        }
    }
}
