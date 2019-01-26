package exceptions.stacktrace;

import java.util.Scanner;

/**
 * A program that displays a trace feature of a recursive method call.
 * 一个展示回归函数调用的轨迹
 * @version 1.0 2019-01-21
 * @author Li Fei
 */
public class StackTraceTest {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.println("Enter n:");
        //int n =in.nextInt();
        int n = 5;
        factorial(n);
    }
    /**
     * Computes the factorial of a number
     * 计算一个数字的阶乘
     * @param n a non-negative integer   一个非负的int类型数字
     * @return n! = 1 * 2 * 3 * ... * n;
     */
    public static int factorial(int n){
        System.out.println("factorial(" + n  + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames= t.getStackTrace();
         for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) r =1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

}