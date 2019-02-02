package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

import utils.chapter1.StdOut;
import utils.chapter1.StdRandom;

/**
 * 1.1.39 Random matches. Write a binarySearch client that takes an int values T as command-line 
 * argument and runs T trials of the following experiment for N= 10^3,10^4,10^5,and 10^6:
 * generate two arrays of N randomly generated positive six-digit int values, and find the number 
 * of values that appear in both arrays. Print a table giving the average value of this quantity 
 * over the T trials for each value of N.
 * 
 * 1.1.39 随机匹配。 编写一个binarySearch的应用程序，它从命令行接收一个整型参数T，并会分别针对
 * N=10^3,10^4,10^5,10^6将以下实验运行T遍：生成两个大小为N的随机6位正整数数组并找出同时存在于两个
 * 数组中的正整数的数量。打印一个表格，对于每个N，都给出T次实验中该数量的平均值。
 */
public class Exercise1139RandomMatchs {

    private static final Logger logger = Logger.getLogger("basicprogrammingmodel.exercises");

    public static void main(String[] args) {
        int t = 10;
        int[] arrLens = {(int)Math.pow(10, 3),(int)Math.pow(10, 4),
                         (int)Math.pow(10, 5),(int)Math.pow(10, 6)};
        logger.info(Arrays.toString(arrLens));
        runMain(t, arrLens);

    }

    private static void runMain(int t, int[] arrLens){
        int[][] tt = new int[t][arrLens.length];
        for (int i = 0; i < arrLens.length; i++) {
            for (int j = 0; j < t; j++) {
                int[] randomArray01 = generateRandomlyArray(arrLens[i]);
                int[] randomArray02 = generateRandomlyArray(arrLens[i]);
                Arrays.sort(randomArray01);
                Arrays.sort(randomArray02);
                int y = -1;
                int count = 0;
                for (int x = 0; x < randomArray01.length; x++) {
                    y = BinarySearch.rank(randomArray01[x], randomArray02, y+1, randomArray02.length-1);
                    if (count > 0){
                        count ++;
                    }
                }
                tt[j][i] = count;
            }
        }
        for (int i = 0; i < arrLens.length; i++) {
            StdOut.printf("%9d", arrLens[i]);
        }
        StdOut.println();
        for (int i = 0; i < tt.length; i++) {
            StdOut.printf("%3d", i);
            for (int j = 0; j < tt[i].length; j++) {
                StdOut.printf("%9d", tt[i][j]);
            }
            StdOut.println();
        }

    }


    private static int[] generateRandomlyArray(int arrLen){
        int[] a = new int[arrLen];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100_000, 1_000_000);
        }
        return a;
    }
}