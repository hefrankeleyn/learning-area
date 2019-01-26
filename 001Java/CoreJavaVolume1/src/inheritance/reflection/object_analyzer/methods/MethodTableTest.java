package inheritance.reflection.object_analyzer.methods;

import java.lang.reflect.Method;

/**
 * MethodTableTest
 */
public class MethodTableTest {

    public static void main(String[] args) {
        // get method pointers to the square and sqrt methods
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            // print tables fo x- and y-values
            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);
            printTable(1, 10, 3, sqrt);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the square of a number
     * @param x
     * @return
     */
    public static double square(double x){
        return x * x;
    }

    /**
     * square root
     * Prints a table with x- and y-values for a method
     * @param from the lower bound for the x-values
     * @param to the upper bound for the x-values
     * @param n the number of rows in the table
     * @param f a method with a double parameter and double return value
     */
    public static void printTable(double from, double to, int n, Method f){
        // print out the method as table header
        System.out.println(f);
        double dx = (to-from)/(n-1);
        
        for (double x = from; x <= to; x += dx) {
            try {
    
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}