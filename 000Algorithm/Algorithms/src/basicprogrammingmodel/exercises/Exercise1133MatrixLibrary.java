package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Exercise1133MatrixLibrary
 */
public class Exercise1133MatrixLibrary {
    private static final Logger myLogger = Logger.getLogger("basicprogrammingmodel.exercises");

    public static void main(String[] args) {
        double[][] a = {{1,3,4,7},
                        {3,2,6,9},
                        {0,2,8,5}};
        double[][] b = {{2,5,7},
                        {3,1,9},
                        {3,1,9},
                        {2,5,1}};
        double[] x = {3,6,9,1};
        double[] y = {6,9,8,7};
        Matrix matrix = new MatrixImpl();
        double dotResult = matrix.dot(x, y);
        myLogger.info("dot value is "+dotResult);
        double[][] matrixMatrixProduct = matrix.mult(a, b);
        myLogger.info("matrix-matrix product:" + Arrays.deepToString(matrixMatrixProduct));
        double[] vectorMatrixProduct = matrix.mult(y, b);
        myLogger.info("vector-matrix product:" + Arrays.toString(vectorMatrixProduct));
        double[] matrixVectorProduct = matrix.mult(a, x);
        myLogger.info("matrix-vector product:" + Arrays.toString(matrixVectorProduct));

    }

    
}


