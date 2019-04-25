package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe48;

import com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe33.Deque;

import java.util.NoSuchElementException;

/**
 * 1.3.48 Two stacks with a deque. Implement two stacks with a single deque so that each operation takes a constant
 * number of deque operation(see EXERCISE 1.3.33)
 * @Date 2019-04-26
 * @Author lifei
 */
public class TwoStacksWithADeque<Item> {

    private Deque<Item> deque;
    private int firstN;
    private int secondN;
    public TwoStacksWithADeque(){
        deque = new Deque<>();
    }

    public void pushFirstStack(Item item){
        deque.pushLeft(item);
        firstN ++;
    }

    public void pushSecondStack(Item item){
        deque.pushRight(item);
        secondN++;
    }

    public Item popFirstStack(){
        if(firstN == 0) throw new NoSuchElementException("no such element");
        Item item = deque.popLeft();
        firstN--;
        return item;
    }

    public Item popSecondStack(){
        if(secondN == 0) throw new NoSuchElementException("overflow");
        Item item = deque.popRight();
        secondN--;
        return item;
    }
}
