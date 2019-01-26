/**
 * 1.1.32 Histogram. Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer N and two double values l and r from the command line 
 * and uses StdDraw to plot a histogram of the count of numbers in the standard input stream 
 * that fall in each of the N intervals defined by dividing (l, r) into N equal-sized intervals.
 * 
 * 1.1.32 直方图。 假设标准输入流中是一系列double值。写一个程序从命令行接受一个整数N和两个double值 l 和r，将(l,r)
 * 分成N段，并使用StdDraw画出输入流的值落入每段的数量的直方图。
 * 
 */
public class Histogram {

    public static void main(String[] args) {
        String[] lines = StdIn.readAllLines();
        for (String line : lines) {
            double dl = Double.parseDouble(line);
            System.out.println(dl);
        }
    }

    public static void histogramSolution(){

    }


}