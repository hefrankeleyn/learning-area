package com.hef.algorithms.fundamentals.quicksort;

import com.hef.algorithms.fundamentals.elementary_sorts.SortCommont;
import com.hef.commons.StdRandom;

/**
 * @Date 2019-07-12
 * @Author lifei
 */
public class Quick extends SortCommont {


    @Override
    public void sort(Comparable[] a) {
        /**
         * 随机打乱 数据a元素的顺序
         * 让这个算法变成随机算法，为了更好预测算法的性能
         * 排除对输入的依赖（Eliminate dependence on input)）
         */
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);

    }

    /**
     * quicksort 的递归排序
     * @param a 数组
     * @param lo 较小的索引值
     * @param hi 较大的索引值
     */
    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        // 分割
        int j = partition(a, lo, hi);
        // 对左边子数组进行排序： a[lo...j-1]
        sort(a, lo, j-1);
        // 对右边子数组进行排序： a[j+1.. hi]
        sort(a, j+1, hi);

    }

    /**
     * quicksort 的关键方法
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j=hi+1;
        Comparable v = a[lo];
        while (true){
            // Scan right, Scan left, check for scan complete, and exchange
            while (less(v, a[++i])) if (i==hi) break;
            while (less(a[--j], v)) if (j==lo) break;
            if (i>=j) break;
            exch(a, i, j);
        }
        // Put v = a[j] into position
        exch(a, lo, j);
        return j;
    }
}
