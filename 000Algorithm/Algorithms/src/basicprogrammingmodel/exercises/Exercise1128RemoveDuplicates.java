package basicprogrammingmodel.exercises;

import java.util.Arrays;

import utils.chapter1.In;

/**
 * Book of Algorithm 1.1.28 Remove duplicates. 
 * @version 1.0 2019-01-14
 * @author lifei
 */
public class Exercise1128RemoveDuplicates{
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        Arrays.toString(whitelist);
        for (int i = 0; i < whitelist.length; i++) {
            int mid = rank(whitelist[i], whitelist, i+1, whitelist.length-1);
            if (mid > i){
                whitelist =  removeOneAndCopyAll(mid, whitelist);
                i--;
            }
        }
        Arrays.toString(whitelist);
    }
    /**
     * 移除原来数组角标为midIndex的元素，将其他元素放在一个新的数组中
     * @param midIndex 角标索引
     * @param whitelist 原来的数组
     * @return  新的数组
     */
    public static int[] removeOneAndCopyAll(int midIndex,int[] whitelist){
        int[] newArray = new int[whitelist.length-1];
        for(int i=0; i<midIndex; i++){
            newArray[i] = whitelist[i];
        }
        for(int i=midIndex+1; i<whitelist.length; i++){
            newArray[i-1]=whitelist[i];
        }
        return newArray;
    }

    /**
     * Testing rank method.
     */
    public static void testRank(){
        int[] a = new int[]{1,2,3,3,4,5,6,7};
        int key = 3;
        int result = rank(key, a, 0, a.length-1);
        System.out.println(result);
    }
    /**
     * binary search method
     * @param key want search keyword
     * @param a order array of int type
     * @param low lowest index of array
     * @param hig highest index of array
     * @return
     */
    public static int rank(int key, int[] a, int low, int hig){
        if(low > hig) return -1;
        int mid = (low + hig) / 2;
        if (a[mid] > key) return rank(key, a, low, mid-1);
        if (a[mid] < key) return rank(key, a, mid+1, hig);
        return mid;
    }
}