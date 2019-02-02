package basicprogrammingmodel.exercises;

/**
 * BinarySearch
 */
public class BinarySearch {

    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length-1);
    }

    public static int rank(int key, int[] a, int minIndex, int maxIndex){
        if (minIndex > maxIndex) return -1;
        int midIndex = (maxIndex + minIndex) / 2;
        if (a[midIndex] > key) return rank(key, a, minIndex, midIndex - 1);
        if (a[midIndex] < key) return rank(key, a, midIndex + 1, maxIndex);
        return midIndex;
    }
}