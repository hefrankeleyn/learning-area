package com.hef.algorithms.fundamentals.elementary_sorts;

import java.util.Arrays;

/**
 * @Date 2019-06-26
 * @Author lifei
 */
public class SortTest {

    public static void main(String[] args) {
        // 希尔排序
        Shell shell = new Shell();
        // 选择排序
        Selection selection = new Selection();
        // 插入排序
        Insertion insertion = new Insertion();


        Integer[] a = new Integer[]{1, 5, 2, 4, 3, 8, 4, 1, 5, 2, 4, 3, 8, 4};
        System.out.println(Arrays.toString(a));
        shell.sort(a);
//        selection.sort(a);
//        insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
