package basicprogrammingmodel.exercises;

import utils.chapter1.StdDraw;
import utils.chapter1.StdRandom;

/**
 * 1.1.31 Random connections. Write a program that takes as command-line arguments an integer N and a double
 * value p (between 0 and 1), plots N equally spaced dots of size .05 on the circumference of a circle,
 * and then, with probability p for each pair of points, draws a gray line connecting them.
 */
public class Exercise1131RandomConnections {
    /**
     * 默认x,y在屏幕展示的空间大小为：1*1
     * 换一个坐标为（0.5,0.5） 半径为 0.5的圆
     * @param args
     */
    public static void main(String[] args) {
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
            points[i] = new Point(0.5 + 0.5*Math.cos(angle * i * Math.PI / 180),
                                  0.5 + 0.5*Math.sin(angle * i * Math.PI / 180));
            // 画出点
            StdDraw.point(points[i].x, points[i].y);
        }
        
        StdDraw.setPenColor(StdDraw.GRAY);
        // 将所有点连线
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i; j < points.length; j++) {
                if(StdRandom.bernoulli(p)){
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
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
}

