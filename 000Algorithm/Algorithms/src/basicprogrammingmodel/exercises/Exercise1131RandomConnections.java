package basicprogrammingmodel.exercises;

import utils.chapter1.StdDraw;
import utils.chapter1.StdRandom;

/**
 * 1.1.31 Random connections. Write a program that takes as command-line
 * arguments an integer N and a double value p (between 0 and 1), plots N
 * equally spaced dots of size .05 on the circumference of a circle, and then,
 * with probability p for each pair of points, draws a gray line connecting
 * them.
 */
public class Exercise1131RandomConnections {

    private static final double SPACESIZE = 0.05;
    /**
     * 默认x,y在屏幕展示的空间大小为：1*1 换一个坐标为（0.5,0.5） 半径为 0.5的圆
     * 
     * @param args
     */
    public static void main(String[] args) {
        int N = 15;
        double p = StdRandom.uniform();
        randomConnectionSolution(SPACESIZE, N, p);
    }

    /**
     * exercise 1.1.31 的解决方案
     * @param spaceSize
     * @param N
     * @param p
     */
    public static void randomConnectionSolution(double spaceSize, int N, double p) {
        // N个大小为0.05且间距相等的点,因此可以算出圆周的周长
        double circumferenceLen = spaceSize * N;
        // 圆周的半径
        double radius = circumferenceLen / Math.PI / 2;
        // 画出坐标系
        StdDraw.setXscale(0, radius * 2);
        StdDraw.setYscale(0, radius * 2);
        // 画一个以(radius,radius) 为圆心，以radius为半径的圆
        StdDraw.circle(radius, radius, radius);
       
        // 将圆平分成N份，每一份的角度为
        double angle = 360.0 / N;
        // 圆上N个点的坐标，放在一个对象数组中
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(radius + radius * Math.cos(i * angle * Math.PI / 180),
                    radius + radius * Math.sin(i * angle * Math.PI / 180));
            System.out.println("radius:" + radius + "x: "+ Math.cos(i * angle * Math.PI / 180));
            // 在圆周上画点
            StdDraw.point(points[i].x, points[i].y);
        }
        // 遍历点，连接线，画点
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(StdRandom.bernoulli(p)){
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }

    /**
     * 测试连接
     */
    public static void randomConnectTest() {
        // N 个 点
        int N = 10;
        // [0,1)之间的随机数
        double p = StdRandom.uniform();
        // N个点的将圆平分为N个扇形，每个扇形的角度为
        double angle = 360.0 / N;
        // 画出坐标为（0.5,0.5） 半径为1的圆
        StdDraw.circle(0.5, 0.5, 0.5);

        // 创建一个集合保存N个点
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
                    0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
            // 画出点
            StdDraw.point(points[i].x, points[i].y);
        }

        StdDraw.setPenColor(StdDraw.GRAY);
        // 将所有点连线
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i; j < points.length; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }

}

/**
 * Point
 */
class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
