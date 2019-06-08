package com.hef.design08.componentmodel.iterator;

import com.hef.design08.componentmodel.Menu;
import com.hef.design08.componentmodel.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Date 2019-06-08
 * @Author lifei
 */
public class CompositeIterator implements Iterator {

    /**
     * Last in fist out
     */
    private Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()){
            return false;
        }else {
            Iterator iterator = (Iterator) stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if(hasNext()){
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            if (menuComponent instanceof Menu){
                stack.push(menuComponent.createIterator());
            }
            return menuComponent;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
