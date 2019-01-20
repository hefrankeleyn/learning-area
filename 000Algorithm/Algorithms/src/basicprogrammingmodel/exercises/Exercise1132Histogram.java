package basicprogrammingmodel.exercises;

import java.util.Arrays;

import utils.chapter1.StdDraw;
import utils.chapter1.StdIn;
import utils.chapter1.StdRandom;

/**
 * 1.1.32 Histogram. Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer N and two double values l and r from the command line 
 * and uses StdDraw to plot a histogram of the count of numbers in the standard input stream 
 * that fall in each of the N intervals defined by dividing (l, r) into N equal-sized intervals.
 * 
 * 1.1.32 直方图。 假设标准输入流中是一系列double值。写一个程序从命令行接受一个整数 N 和两个double值 l 和 r ，将(l,r)
 * 分成N段，并使用StdDraw画出输入流的值落入每段的数量的直方图。
 * 
 * 思路：
 * 1、收集数据。做直方图的数据一般应大于50个；
 * 2、确定数据的极差。用数据的最大值减去最小值，获得；
 * 3、确定组距（h）。先确定直方图的组数，然后以此组数减去极差，可得直方图每组的宽度，即组距。
 *    组数的确定要适当，组数太少会引起较大计算误差；组数太多，会影响数据数据分组规律的明显性，
 *    且计算工作量加大。
 * 4、确定各组的界限值。为了避免出现数据值与组界限重合而造成频数据计算困难，组界限值单位应取最小测量单位的1/2,
 *    分组时，应当把数据表中最大值和最小值包括在内。
 */
public class Exercise1132Histogram {

    public static void main(String[] args) {
        //barChart();
        // represent argument N
        int N = 3;
        // represent argument l
        // represent argument r
        double l = 1.09;
        double r = 23.32;
        // represent double stream
        double[] a = {1.08, 1.21, 2.33, 3.35, 8.78, 6.98, 7.99, 10.21, 15.22, 21.23, 14.51, 16.77, 18.23};
        histogramSolution(N, l, r, a);
    }
    /**
     * solution 
     * @param N the numbers of intervals 
     * @param l interval left value
     * @param r interval right value
     * @param a double stream
     */
    public static void histogramSolution(int N, double l, double r, double[] a){
        // double stream的组距
        Arrays.sort(a);
        double interval = (r -l) / N;
        // histogram 的组距
        double histogramInterval = 1.0 / N;
        
        for (int i = 0; i < N; i++) {
            // double stream 组距左边的值
            double dsLeft = interval * i + l;
            // double stream 组距右边的值
            double dsRight = interval * (i+1) + l;
            // 矩形中心位置x轴的坐标
            double x = histogramInterval *i +histogramInterval / 2;

            // 频次，代表直方图的高
            int countTemp = 0;
            for (int j = 0; j < a.length; j++) {
                // 频次
                if (a[j] > dsLeft && a[j] < dsRight ) {
                    countTemp ++;
                }
            }
            double p = (countTemp * 1.0) / a.length;
            //double p = (countTemp * 1.0) / N;
            // 矩形中心位置y周的坐标
            double y = p / 2;
            StdDraw.filledRectangle(x, y, histogramInterval / 2, y);
        }
    }

    /**
     * bar chart example
     */
    public static void barChart(){
        int N = 5;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }

        for (int i = 0; i < N; i++) {
            //矩形一半的宽
            double rw = 0.5 / N;
            // 矩形一半的高
            double rh = a[i] /2.0;
            //矩形中心点x轴的坐标
            double x = 1.0 * i / N + 1.0 / N / 2;
            // 矩形中心点y轴的坐标
            double y = rh;
            System.out.println("x=" + x + ",y=" + y + ",rw=" + rw + ",rh=" + rh);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    /**
     * 
     */
    public static void test(String[] args){
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        // 定义一个数据存放将(l,r) 分成N分的坐标
        His[] hiss = new His[N];
        if(l<=r){
            return;
        }
        double interval = (r-l) / N;
        for (int i = 0; i < N; i++) {
            hiss[i] = new His(l + i * interval,  l + i * interval +interval );
        }
        int[] counts = new int[N];
        String[] lines = StdIn.readAllLines();
        for (String line : lines) {
            double dl = Double.parseDouble(line);
            for (int i = 0; i < N; i++) {
                double lower = l + i * interval;
                double heigher = l + i * interval + interval;
                if (dl>= lower && dl < heigher){
                    counts[i] += 1;
                }
            }
        }
    }


}

class His{
    double x;
    double y;
    public His(double x, double y){
        this.x = x;
        this.y = y;
    }
}