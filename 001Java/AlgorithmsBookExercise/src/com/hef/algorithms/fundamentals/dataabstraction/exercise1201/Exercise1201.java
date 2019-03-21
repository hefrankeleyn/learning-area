package com.hef.algorithms.fundamentals.dataabstraction.exercise1201;

import com.hef.commons.StdDraw;

import java.awt.*;
import java.util.Arrays;

/**
 * @description Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance separating the
 * closest pair of points.
 */
public class Exercise1201 {

    public static void main(String[] args) {

        int n = 100;
        double closestDistance = Exercise1201.getClosestDistance(n);
        System.out.println(closestDistance);
    }

    public static double getClosestDistance(int n){
        double[] xA = new double[n];
        double[] yA = new double[n];
        StdDraw.square(0,0,1);
        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < n; i++) {
            xA[i] = Math.random();
            yA[i] = Math.random();
            StdDraw.point(xA[i], yA[i]);
        }
        int disLen= 0;
        for (int i = 0; i < n; i++) {
            disLen += i;
        }
        double[] distances = new double[disLen];
        int ii = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double xd = Math.abs(xA[i] - xA[j]);
                double yd = Math.abs(yA[i] - yA[j]);
                double distance = Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2));
                distances[ii] = distance;
                ii ++;
            }
        }
        Arrays.sort(distances);
        return distances[0];
    }
}
