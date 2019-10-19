package com.hef.test;

import com.hef.algorithms.utils.SortMethodUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Date 2019/10/19
 * @Author lifei
 */
public class SortMethodUtilTest {

    @Test
    public void selectionSortTest() {
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void insertionSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void shellSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void topButtomMergeSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.topBottomMergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void buttomTopMergeSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.bottomToTopMergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
