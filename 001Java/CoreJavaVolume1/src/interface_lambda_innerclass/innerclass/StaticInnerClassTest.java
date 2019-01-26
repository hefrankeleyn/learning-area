package interface_lambda_innerclass.innerclass;

/**
 * StaticInnerClassTest
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        double[] d =new double[20];
        for(int i=0; i < d.length; i++){
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min=" + p.getFirst());
        System.out.println("max=" + p.getSecond());
    }
}

class ArrayAlg{
    /**
     * A pair of floating-point numbers.
     */
    public static class Pair{
        private double first;
        private double second;
        /**
         * Constructs a pair from two floating-point numbers
         * @param first the first number
         * @param second the second number
         */
        public Pair(double first, double second){
            this.first = first;
            this.second = second;
        }
        /**
         * Return the first number of the pair
         * @return the first number
         */
        public double getFirst(){
            return this.first;
        }

        /**
         * Return the second number of the pair
         * @return the second number
         */
        public double getSecond(){
            return this.second;
        }
    }

    public static Pair minmax(double[] values){
        // 正无穷
        double min = Double.POSITIVE_INFINITY;
        // 负无穷
        double max = Double.NEGATIVE_INFINITY;
        for (double x : values) {
            if (min > x) min = x;
            if (max < x) max = x;
        }

        return new Pair(min, max);
    }
}