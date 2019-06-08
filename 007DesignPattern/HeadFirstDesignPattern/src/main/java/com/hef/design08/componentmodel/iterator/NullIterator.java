package com.hef.design08.componentmodel.iterator;

import java.util.Iterator;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
