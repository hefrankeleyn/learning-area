package com.hef.test;

import com.hef.algorithms.utils.SortMethodUtil;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void quickSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.arrayShuffle(a);
        System.out.println(Arrays.toString(a));
        SortMethodUtil.quickSort(a);
        System.out.println(Arrays.toString(a));
    }


    @Test
    public void threeWayQuickSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.arrayShuffle(a);
        System.out.println(Arrays.toString(a));
        SortMethodUtil.threeWayQuickSort(a);
        System.out.println(Arrays.toString(a));
        Integer[] b = new Integer[]{5, 1, 12, 5, 1, 12, 11, 5, 11};
        System.out.println(Arrays.toString(b));
        SortMethodUtil.threeWayQuickSort(b);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void heapSortTest(){
        Integer[] a = new Integer[]{3, 1, 9, 5, 0, 12, 11, 50, 23};
        System.out.println(Arrays.toString(a));
        SortMethodUtil.heapSort(a);
        System.out.println(Arrays.toString(a));

        Integer[] b = new Integer[3];
        b[0]= 23;
        SortMethodUtil.swim(b, 0);
        b[1]=45;
        SortMethodUtil.swim(b, 1);
        b[2]=57;
        SortMethodUtil.swim(b, 2);
        System.out.println(Arrays.toString(b));
        SortMethodUtil.heapSort(b);
        System.out.println(Arrays.toString(b));

    }
}
