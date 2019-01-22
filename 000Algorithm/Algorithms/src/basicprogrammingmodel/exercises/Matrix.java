package basicprogrammingmodel.exercises;

/**
 * Matrix library
 */
public interface Matrix {
    /**
     * vector dot product
     * @param x
     * @param y
     * @return
     */
    double dot(double[] x, double[] y);
    /**
     * matrix-matrix product
     */
    double[][] mult(double[][] a, double[][] b);
    /**
     * transpose
     */
    double[][] transpose(double[][] a);
    /**
     * matrix-vector product
     * @param a
     * @param x
     * @return
     */
    double[] mult(double[][] a, double[] x);
    /**
     * vector-matrix product
     * @param y
     * @param a
     * @return
     */
    double[] mult(double[] y, double[][] a);
}