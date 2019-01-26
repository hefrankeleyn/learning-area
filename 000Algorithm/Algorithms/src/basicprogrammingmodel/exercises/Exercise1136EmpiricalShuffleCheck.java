package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

import utils.chapter1.StdOut;
import utils.chapter1.StdRandom;

/**
 * 1.1.36 Empirical shuffle check.
 * 
 * 1.1.36 证实洗牌�?查�?�运行计算实验去验证我们�?32也作为广告的洗牌代码。写�?个ShuffleTest程序 获取命令行参数M和N�?
 * 对一个数组大小为M的数组做N次洗牌，在每次洗牌前数组都被初始化为:a[i]=i，并且打印一个M*M的表格�?�对于所有的j列，
 * 行i表示的是i在打乱后落在j的位置的次数。数组中�?有元素的值都应该接近于N/M�?
 */
public class Exercise1136EmpiricalShuffleCheck {

    public static void main(String[] args) {
        int M = 10;
        int N = 100;
        //int[][] result = ShuffleTest.shuffleCheck(M, N);
        double[][] disparityA = ShuffleTest.disparity(M, N);
    }


}

class ShuffleTest{
    private static final Logger logger = Logger.getLogger("basicprogrammingmodel.exercises");
    public static void shuffle(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // Exchage a[i] with random element in a[i..N-1]
            // choose random integer between i and N
            int r = i + StdRandom.uniform(N-i);
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