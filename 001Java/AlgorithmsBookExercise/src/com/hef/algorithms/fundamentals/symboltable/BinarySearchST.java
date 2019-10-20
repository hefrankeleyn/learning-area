package com.hef.algorithms.fundamentals.symboltable;

/**
 * @Date 2019/10/20
 * @Author lifei
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    public void put(Key key, Value value){
        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (N==keys.length) return;
        for (int j = N; j > i ; j--) {
            keys[j]=keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * binary search  key
     * @param key
     * @return
     */
    public int rank(Key key){
        int lo=0, hi= N-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp<0) hi = mid-1;
            else if(cmp>0) lo = mid+1;
            else return mid;
        }
        return lo;
    }

    /**
     * recursive rank
     * @param key
     * @param lo
     * @param hi
     * @return
     */
    public int rank(Key key, int lo, int hi){
        if (lo>hi) return lo;
        int mid = lo + (hi-lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp<0) return rank(key, lo, mid-1);
        else if (cmp>0) return rank(key, mid+1 , hi);
        else return cmp;
    }

}
