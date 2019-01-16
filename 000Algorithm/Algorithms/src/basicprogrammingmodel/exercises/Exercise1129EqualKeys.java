package basicprogrammingmodel.exercises;

import java.util.Arrays;

/**
 * 1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and a sorted array of int values
 * (some of which may be equal) as arguments and returns the number of elements that are smaller than the key
 * and a similar method method count() that returns the number of elements equal to the key.
 * Note: If i and j are the values returned by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are
 * the values in the array that are equal to key.
 * @version 1.0 2019-01-15
 * @author lifei
 */
public class Exercise1129EqualKeys{

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 7, 13, 1, 10, 14, 3};
        int key = 10;
        Arrays.sort(a);
        int r1 = rank(key, a);
        int r2 = count(key, a);
        
        int result = validResult(r1, r2, a);
        System.out.println("key: "+key+", result: "+result);
    }

    public static int validResult(int r1, int r2, int[] a){
        System.out.println("r1:"+r1+", "+r2);
        int result =0;
        for(int i=r1; i<=r1+r2-1; i++){
            result += a[i];
        }
        return result;
    }
    /**
     * 获取值小于k的元素数量
     * @param key  值
     * @param a 数组
     * @return
     */
    public static int rank(int key, int[] a){
        int i=0;
        while(i<a.length && a[i] < key){
            i++;
        }
        return i;
    }
    /**
     * 获取与key值相等的数量
     * @param key 
     * @param a
     * @return
     */
    public static int count(int key, int[] a){
        int result =0;
        for(int i=0; i<a.length; i++){
            if (a[i] == key){
                result ++;
            }
        }
        return result;
    }
}