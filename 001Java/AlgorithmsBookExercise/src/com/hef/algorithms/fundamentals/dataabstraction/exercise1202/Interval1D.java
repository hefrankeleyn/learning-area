package com.hef.algorithms.fundamentals.dataabstraction.exercise1202;

import com.hef.commons.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Write an Interval1D client that takes an int value N as command-line argument,
 * read N intervals (each defined by a pair of double values) from standard input,
 * and prints all pairs that intersect.
 * https://algs4.cs.princeton.edu/12oop/Interval1D.java.html
 */
public class Interval1D {

    private final double min;
    private final double max;
    public static final Comparator<Interval1D> MIN_ENDPOINT_ORDER  = new MinEndPointComparator();
    public static final Comparator<Interval1D> MAX_ENDPOINT_ORDER  = new MaxEndPointComparator();
    public static final Comparator<Interval1D> LENGTH_ORDER  = new LengthComparator();

    public Interval1D(double min, double max) {
        if (Double.isInfinite(min) || Double.isInfinite(max)){
            throw new IllegalArgumentException("Endpoints must be finite");
        }if (Double.isNaN(min) || Double.isNaN(max)){
            throw new IllegalArgumentException("Endpoints cannot be NaN.");
        }
        // Convert -0.0 to 0.0
        if (min == 0.0) min=0.0;
        if (max == 0.0) max=0.0;
        if (min <= max){
            this.min = min;
            this.max = max;
        }
        else throw new IllegalArgumentException("Illegal interval");
    }

    /**
     * return the min endpoint of interval
     * @return the min endpoint of interval
     */
    public double min(){
        return min;
    }

    /**
     * return the max endpoint of interval
     * @return the max endpoint of interval
     */
    public double max(){
        return max;
    }

    /**
     * return true if this interval intersects the special interval
     * @param that the other interval
     * @return {@code true} if this interval intersect the argument interval
     *         {@code false} otherwise
     */
    public boolean interects(Interval1D that) {
        if (this.max < that.min) return false;
        if (that.max < this.min) return false;
        return true;
    }

    /**
     * Return true if this interval contains the special value
     * @param x the value
     * @return {@code true} if interval contains the value {@code x}
     *         {@code false} otherwise
     */
    public boolean containts(double x) {
        return (min <= x) && (max >= x);
    }

    /**
     * Return the length of interval
     * @return the length of interval (max-min)
     */
    public double length(){
        return max - min;
    }

    /**
     * Return a string representation of the interval
     * @return a string representation of this interval in the form [min, max]
     */
    @Override
    public String toString() {
        return "[" + min +", " + max +"]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (otherObject.getClass() != this.getClass()) return false;
        Interval1D other = (Interval1D) otherObject;

        return (this.min == other.min) && (this.max == other.max) ;
    }

    @Override
    public int hashCode() {
        int hash1 =((Double)min).hashCode();
        int hash2 =((Double)max).hashCode();
        return 31*hash1 + hash2;
    }

    private static class MinEndPointComparator implements Comparator<Interval1D> {

        @Override
        public int compare(Interval1D a, Interval1D b) {
            if (a.min < b.min) return -1;
            else if (a.min > b.min) return +1;
            else if (a.max < b.max) return -1;
            else if (a.max > b.max) return +1;
            else return 0;
        }
    }


    private static class MaxEndPointComparator implements Comparator<Interval1D> {

        @Override
        public int compare(Interval1D a, Interval1D b) {
            if (a.max < b.max) return -1;
            else if (a.max > b.max) return +1;
            else if (a.min < b.min) return -1;
            else if (a.min > b.min) return +1;
            else return 0;
        }
    }

    private static class LengthComparator implements Comparator<Interval1D> {
        @Override
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if (alen < blen) return -1;
            else if (alen > blen) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Interval1D[] intervals = new Interval1D[4];
        intervals[0] = new Interval1D(15.0, 33.0);
        intervals[1] = new Interval1D(45.0, 60.0);
        intervals[2] = new Interval1D(20.0, 70.0);
        intervals[3] = new Interval1D(46.0, 55.0);
        StdOut.println("Unsorted");
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by min endpoint");
        Arrays.sort(intervals, Interval1D.MIN_ENDPOINT_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by max endpoint");
        Arrays.sort(intervals, Interval1D.MAX_ENDPOINT_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by length");
        Arrays.sort(intervals, Interval1D.LENGTH_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();
    }
}
