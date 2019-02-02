package basicprogrammingmodel.model1;

import utils.chapter1.StdDraw;

/**
 * StdDrawTest
 */
public class StdDrawTest {

    public static void main(String[] args) {
        //drawPoint();
        drawCircle();
    }

    public static void drawPoint(){
        // 设置画笔的颜色
        StdDraw.setPenColor(StdDraw.RED);
        // 设置画笔的大小
        StdDraw.setPenRadius(0.5);
        // 画点
        StdDraw.point(0.5, 0.5);
    }
    /**
     * 从侧面印证，不设置x和y轴的话，预设的x和y轴大小是1个单位
     */
    public static void drawLine(){

    }
    /**
     * 画一个半径为0.5，圆心坐标为（0.5， 0.5）的圆
     */
    public static void drawCircle(){
        StdDraw.circle(0.5, 0.5, 0.5);
    }
}