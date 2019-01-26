package interface_lambda_innerclass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ArraySortTest
 */
public class ArraySortTest {

    public static void main(String[] args) {
        sortStringArrayTest();
    }

    public static void sortStringArrayTest(){
        Comparator<String> comp = new LengthComparator();
        String[] friends = {"Peter", "Paul", "Mary"};
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, comp);
        System.out.println(Arrays.toString(friends));

        // 这个compare方法要在比较器对象上调用，而不是在字符串本身上调用
        if(comp.compare(friends[1], friends[2]) > 0){
            System.out.println("friends[1] is bigger.");
        }


    }
    public static void showArraySortMethod(){
        Integer[] a= {1};
        Arrays.sort(a);
    }
}

class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}