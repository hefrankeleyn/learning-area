package inheritance.reflection.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

import inheritance.reflection.object_analyzer.ObjectAnalyzer;

/**
 * ArraysCopyTest
 */
public class ArraysCopyTest {

    public static void main(String[] args) {
        Integer[] a = {1,3,5,2};
        String[] sa = {"aaa","bbb","ccc"};
        int[] ia = {1,1,2,4};
        //copyOfTest(a);
        // 
        //System.out.println(new ObjectAnalyzer().toString(arrayCopyTest(sa, 3)));

        Integer[] aC = (Integer[]) goodCopyOf(a, 4);
        String[] saC = (String[]) goodCopyOf(sa, 3);
        int[] iaC = (int[]) goodCopyOf(ia, 3);
        System.out.println(new ObjectAnalyzer().toString(aC));
        System.out.println(new ObjectAnalyzer().toString(saC));
        System.out.println(new ObjectAnalyzer().toString(iaC));
    }
    /**
     * common use array copy method
     * @param a
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength){
        Class cl = a.getClass();
        if (! cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
    /**
     * 
     * @param a
     * @param newLength
     * @return
     */
    public static Object[] arrayCopyTest(Object[] a, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }
    /**
     * 
     * @param a
     */
    public static void copyOfTest(Integer[] a){
        Integer[] b = Arrays.copyOf(a, 2 * a.length);
        System.out.println(new ObjectAnalyzer().toString(a));
        System.out.println(new ObjectAnalyzer().toString(b));

    }
}