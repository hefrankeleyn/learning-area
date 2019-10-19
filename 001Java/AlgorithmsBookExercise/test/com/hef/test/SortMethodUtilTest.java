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
}
