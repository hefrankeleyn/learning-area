package com.hef.design08.iteratormodel;

import java.util.Iterator;

/**
 * @Date 2019-06-07
 * @Author lifei
 */
public class DinerMenuIterator implements Iterator {


    private MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if(position >= items.length || items[position] == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem item = items[position];
        position ++;
        return item;
    }

    @Override
    public void remove() {
        if(hasNext()){
            int j=position;
            for (int i = position + 1; i < items.length && items[i]!=null ; i++, j++) {
                items[i-1] = items[i];
            }
            items[j] = null;
        }else {
            throw new RuntimeException("over flow");
        }
    }
}
