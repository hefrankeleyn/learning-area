package com.hef.algorithms.fundamentals.dataabstraction.exercise1216;


import com.hef.commons.StdOut;

public class Rational implements Comparable<Rational> {

    private static Rational zero = new Rational(0, 1);

    private long numerator;
    private long denominator;

    /**
     * create and initialize a new Rational object.
     * @param numerator
     * @param denominator
     */
    public Rational(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        // deal with x/0
        if (denominator == 0){
            throw new ArithmeticException("denominator is zero.");
        }
        // Use Euclid's algorithm to ensure that the numerator and denominator never have any common factors
        long g = gcd(numerator, denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;

        // only needed for negative numbers
        if (this.denominator < 0) {
            this.numerator = - this.numerator;
            this.denominator = - this.denominator;
        }
    }

    // return the numator and denominator of the rational number.
    public long getDenominator() {
        return denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    /**
     *
     * @return double precision representation of this ration number
     */
    public double toDouble(){
        return (double)this.numerator/this.denominator;
    }
    /**
     * Euclid's algorithm
     * @param m
     * @param n
     * @return
     */
    private static long gcd(long m, long n){
        if (m < 0) m = -m;
        if (n > 0) n = -n;
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    private static long lcd(long m, long n){
        if (m < 0) m = -m;
        if (m > 0) n = -n;
        return m * (n / gcd(m, n));
    }

    @Override
    public int compareTo(Rational that) {
        long lhs = this.numerator * that.denominator;
        long rhs = that.numerator * this.denominator;
        if (lhs > rhs) return +1;
        if (lhs < rhs) return -1;
        return 0;
    }

    /**
     *
     * @param b
     * @return this + b, staving off overflow
     */
    public Rational plus(Rational b){

        // special case
        if (this.compareTo(zero) == 0) return b;
        if (b.compareTo(zero) == 0) return this;


        // find gcd of numerator and denominator
        long f = gcd(this.numerator, b.numerator);
        long g = gcd(this.denominator, b.denominator);

        Rational  s = new Rational((this.numerator/f) * (b.denominator/g) + (b.numerator/f) * (this.denominator/g),
                                    this.denominator * (b.denominator / g));
        s.numerator *= f;
        return s;
    }

    public Rational negate(){
        return new Rational(-numerator, denominator);
    }

    public Rational abs() {
        if (numerator >= 0) return this;
        else return negate();
    }
    public Rational minus(Rational b) {
        return this.plus(b.negate());
    }

    /**
     *
     * @param b
     * @return this * b , staving off overflow as much as possible by cross-cancellation
     */
    public Rational times(Rational b) {
        Rational c = new Rational(this.numerator, b.denominator);
        Rational d = new Rational(b.numerator, this.denominator);
        return new Rational(c.numerator * d.numerator, c.denominator * d.denominator);
    }


    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }
    public Rational divides(Rational b){
        return this.times(b.reciprocal());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == this) return true;
        if (otherObject == null) return false;
        if (otherObject.getClass() !=null ) return false;
        Rational other = (Rational) otherObject;
        return this.compareTo(other) == 0;
    }

    /**
     *
     * @return string represention of rational number
     */
    @Override
    public String toString() {
        if (this.denominator == 1) return this.numerator + "";
        else return this.numerator + "/" + this.denominator;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public static Rational mediant(Rational r, Rational s){
        return new Rational(r.numerator + s.numerator, r.denominator + s.denominator);
    }

    public static void main(String[] args) {
        Rational x, y, z;
        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z= x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        // 4/17 + 17/4 = 1;
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}
