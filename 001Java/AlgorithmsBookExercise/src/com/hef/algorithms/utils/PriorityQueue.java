package com.hef.algorithms.utils;

/**
 * @Date 2019/10/20
 * @Author lifei
 */
public class PriorityQueue<Key extends Comparable<Key>> {

    private Key[] a;
    private int N;

    public PriorityQueue(int max){
        a = (Key[])new Comparable[max+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key k){
        if (N==a.length) return;
        a[++N] = k;
        swim(N);
    }

    public Key delMax(){
        if (isEmpty()) return null;
        Key k = a[1];
        a[1] = a[N--];
        a[N+1] = null;
        sink(1);
        return k;
    }

    private void swim(int i){
        while (i>1 && less(a[i/2], a[i])){
            exch(a, i/2, i);
            i = i/2;
        }
    }

    private void sink(int i){
        while (i*2<N){
            int j = i * 2;
            if (j+1<N && less(a[j], a[j+1])) j = j+1;
            if (less(a[j], a[i])) break;
            exch(a, j, i);
            i = j;
        }
    }

    private boolean less(Key k1, Key k2){
        return k1.compareTo(k2)<0;
    }

    private void exch(Key[] a, int i, int j){
        Key tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

}
