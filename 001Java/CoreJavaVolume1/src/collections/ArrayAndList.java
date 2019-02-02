package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayAndList
 */
public class ArrayAndList {

    public static void main(String[] args) {
        arrayToList();
    }
    public static void arrayToList(){
        String[] a = {"aaa", "bbb", "ccc"};
        List<String> list = Arrays.asList(a);
        System.out.println(list);

        List<Integer> intList = new ArrayList<>();
        intList.add(12);
        intList.add(13);
        intList.add(132);
        Integer[] intArray = intList.toArray(new Integer[0]);
        for (Integer i : intArray) {
            System.out.println(i);
        }
    }
}