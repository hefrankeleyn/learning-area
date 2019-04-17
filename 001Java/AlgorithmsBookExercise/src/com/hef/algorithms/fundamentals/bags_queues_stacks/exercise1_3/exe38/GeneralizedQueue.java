package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe38;

/**
 * 1.3.38 Delete kth element. Implement a class that supports the following API;
 * First, develop an implementation that uses an array implementation, and then develop one that uses a linked-list
 * implementation.
 * Note: the algorithms and data structures that we introduce in chapter 3 make it possible to develop an implementation
 * that can guarantee that both insert() adn delete() take time prortional to the logarithm of the number of items in the queue
 * @param <Item>
 */
public interface GeneralizedQueue<Item> {

    /**
     * is the queue empty
     * @return
     */
    boolean isEmpty();

    /**
     * add an item
     * @param x
     */
    void insert(Item x);

    /**
     * delete and return kth least recently inserted item
     * @param k
     * @return
     */
    Item delete(int k);
}
