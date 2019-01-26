package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

import utils.chapter1.StdOut;
import utils.chapter1.StdRandom;

/**
 * 1.1.37 Bad shuffling. Suppose that you choose a random integer between 0 and N-1 
 * in our shuffling code instead of one between i and N-1. Show that the resulting order
 * is not equally likely to be one of the N! possibilities. Run the test of the previous 
 * exercise  for this version.
 * 
 * 1.1.37 坏洗牌。 假设在我们的随机代码中，从0到N-1 选择一个随机数 而不是从 i 到 N-1中选择。证明那个排序的结果
 * 不等于 N! 中可能性，运行上一道题的测试为这一版本。
 */
public class Exercise1137BadShuffling {

    public static void main(String[] args) {
        
    }
}

class ShuffleTest{
    private static final Logger logger = Logger.getLogger("basicprogrammingmodel.exercises");
    public static void shuffle(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // Exchage a[i] with random element in a[i..N-1]
            // choose random integer between i and N-1
            //int r = i + StdRandom.uniform(N-i);

            // choose random integer between 0 and N-1
            int r =  StdRandom.uniform(N);
            int temp  = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int[][] shuffleCheck(int M, int N){
        int[] a = new int[M];
        int[][] result = new int[M][M];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        StdRandom.setSeed(123456);
        int count = 0;
        while(count < N){
            Arrays.sort(a);
            shuffle(a);
            for (int i = 0; i < a.length; i++) {
                result[a[i]][i] += 1; 
            }
            count ++;
        }
        logger.info(Arrays.deepToString(result));
        return result;
    }

    public static double[][] disparity(int M, int N){
        int[][] a= shuffleCheck(M, N);
        showArray(a);
        return disparity(M, N, a);
    }
    public static void showArray(int[][] a){
        StdOut.printf("%5s", "");
        for (int i = 0; i < a[0].length; i++) {
            StdOut.printf("%4d", i);
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            StdOut.printf("%5s", i);
            for (int j = 0; j < a[i].length; j++) {
                StdOut.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }
    private static double[][] disparity(int M, int N, int[][] a){
        double[][] disparityArray = new double[a.length][a[0].length];
        double temp = Double.parseDouble(N+"") / M;
        for (int i = 0; i < a.length; i++) {
            for(int j =0; j < a[i].length; j++){
                disparityArray[i][j] = Math.abs(Double.parseDouble(a[i][j] + "") - temp);
            }
        }
        logger.info("disparityArray: " + Arrays.deepToString(disparityArray));
        return disparityArray;
    }
}