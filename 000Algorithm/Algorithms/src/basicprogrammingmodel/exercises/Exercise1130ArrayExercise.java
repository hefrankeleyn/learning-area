package basicprogrammingmodel.exercises;

import java.util.Arrays;

/**
 * 1.1.30 Array exercise. Write a code fragment that creates an M-by-N boolean array a[][]
 * such that a[i][j] is true if i and j are relatively prime
 * @version 1.0 2019-01-16
 * @author Li Fei
 */
public class Exercise1130ArrayExercise {


    public static void main(String[] args) {
        int result = euclidAlgorithm(0, 10);
        System.out.println(result);
        boolean[][] a = new boolean[3][5];
        arrayExercise(a);
        System.out.println(Arrays.deepToString(a));
    }
    /**
     * 
     * @param a
     */
    public static void arrayExercise(boolean[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0 ; j<a[i].length; j++){
                if(i==0 || j==0){
                    a[i][j] = false;
                }else if (euclidAlgorithm(i, j) == 1){
                    a[i][j] = true;
                }else{
                    a[i][j] = false;
                }
            }
        }
    }
    /**
     * Euclid's algorithm: fetch the greatest common divisor
     * 辗转相除法
     * @param a
     * @param b
     * @return
     */
    public static int euclidAlgorithm(int a, int b){
        if (b==0) return a;
        return euclidAlgorithm(b, a%b);
    }
    
}