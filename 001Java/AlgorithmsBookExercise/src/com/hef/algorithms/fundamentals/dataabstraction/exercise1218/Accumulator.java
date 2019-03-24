package com.hef.algorithms.fundamentals.dataabstraction.exercise1218;

import com.hef.commons.StdOut;

/**
 * The {@code Accumulator} class is a data type for computing running mean, simple standard deviation,
 * and simple variance of a stream of real numbers.
 * 这个 {@code Accumulator} 类 是一个数据类型，为了计算一连串真实的数字，运行时平均数，简单标准差，和简单的方差。
 * <p>
 * This implementation uses a one-pass algorithm that is less susceptible to floating-point roundoff error than
 * the more straightforward implementation based on saving the sum of the squares of the numbers.
 * 这个实现使用了 one-pass 算法，它比直接基于保存一系列数值和的更直接的实现更少受到浮点舍入偏差的影响。
 * This technique is due to
 * <a href = "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">B. P. Welford</a>.
 * Each operation takes constant time in the worst case.
 * 最坏的情况下，每个操作需要执行固定的时间。
 * The amount of memory is constant - the data values are not stored.
 * 内存量是常量，数据值不被存储。
 * </p>
 *
 *
 *
 */
public class Accumulator {
    // 数值的数量
    private int n;       // number of data values
    // 样本的方差
    private double sum;  // sample variable * （n -1）
    // 平均值
    private double mu;   // sample mean

    // Initiates an accumulator
    public Accumulator() {
        this.n = 0;
        this.sum = 0.0;
        this.mu = 0.0;
    }

    /**
     * Adds the specified data value to the accumulator
     * @param x the data value
     */
    public void addDataVale(double x){
        n++;
        double delta = x - mu;
        mu = delta / n;

    }

    public double mean(){
        return mu;
    }

    public static void main(String[] args) {
        double[] in = new double[]{4.0, 8.0};

        Accumulator stats = new Accumulator();
        for (double x: in) {
            stats.addDataVale(x);
        }

        StdOut.printf("mean = %.5f\n", stats.mean());
    }

}
