package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Matrix
 */
public class MatrixImpl implements Matrix{

    private static final Logger myLogger = Logger.getLogger("basicprogrammingmodel.exercises");

    /**
     * vector dot product
     */
    @Override
    public double dot(double[] x, double[] y) {
        myLogger.info("x:" + Arrays.toString(x) +", y: " + Arrays.toString(y));
        if (x.length != y.length){
            throw new RuntimeException("length of x array must equals length of y.");
        }
        double dotProduct = 0.0;
        for (int i = 0; i < x.length; i++) {
            dotProduct += x[i]*y[i];
        }
        return dotProduct;
    }
    /**
     * vector-matrix product
     */
    @Override
    public double[] mult(double[] y, double[][] a) {
        if(y.length != a.length){
            throw new RuntimeException("length of y array must equals length of a");
        }
        double[] result = new double[a[0].length];
        for (int i = 0; i < result.length; i++) {
            double temp = 0.0;
            for (int j = 0; j < y.length; j++) {
                temp += y[j] * a[j][i];
            }
            result[i] = temp;
        }
        return result;
    }
    /**
     * matrix-matrix product
     */
    @Override
    public double[] mult(double[][] a, double[] x) {
        if (a[0].length != x.length){
            throw new RuntimeException("a[0] length musth equals x length");
        }
        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            double temp = 0.0;
            for (int j = 0; j < a[i].length; j++) {
                temp += a[i][j] * x[j];
            }
            result[i] = temp;
        }
        return result;
    }
    /**
     * 两个矩阵的乘法仅当第�?个矩阵A的列数（column）和另一个矩阵B的行�?(row) 相等才能定义。如果A是m * n的矩阵，
     * B�? n * p 的矩阵，他们的乘积是�?个m * p的矩阵�??
     * matrix-matrix product
     */
    @Override
    public double[][] mult(double[][] a, double[][] b) {
        if ((a == null || a.length ==0) || (b == null || b.length ==0)){
            throw new RuntimeException("a and b can't empty.");
        }
        if (a[0].length != b.length ){
            throw new RuntimeException("can't calculate product because column of a not equals row of b.");
        }

        double[][] matrixProduct = new double[a.length][b[0].length];
        for (int i = 0; i < matrixProduct.length; i++) {
            for(int j=0; j<matrixProduct[i].length; j++){
                double temp=0.0;
                for (int x = 0; x < a[i].length; x++) {
                    temp += a[i][x] * b[x][i];
                }
                matrixProduct[i][j] = temp;
            }
        }
        return matrixProduct;
    }
    /**
     * 把a的横行写成a的纵�?
     * 把a的纵行写成a的横�?
     */
    @Override
    public double[][] transpose(double[][] a) {
        double[][] trans = new double[a[0].length][a.length];
        for (int i = 0; i < trans.length; i++) {
            for(int j=0; j<trans[i].length; j++){
                trans[j][i] = a[i][j];
            }
        }
        return trans;
    }
}