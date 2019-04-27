package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe49;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;

/**
 * Queue with a constant number of stacks. Implement a queue with three stacks so that each queue operation takes a
 * constant (worst-case) number of stack operations.
 * warning: high degree of difficulty
 *
 * queue: FIFO first-in-first-out
 * stack: FILO first-in-last-out
 * @Date 2019-04-26
 * @Author lifei
 */
public class QueueWithStacks<Item> {

    private Stack<Item> firstStack;
    private Stack<Item> secondStack;
    private Stack<Item> threeStack;
    private static final int NUMBER = 3;
    private int N;
    public QueueWithStacks(){
        firstStack = new Stack<>();
        secondStack = new Stack<>();
        threeStack = new Stack<>();
    }

    public int size(){
        return firstStack.size() + secondStack.size() + threeStack.size();
    }

    public boolean isEmpty(){
        int total = firstStack.size() + secondStack.size() + threeStack.size();
        return total == 0;
    }

    public void push(Item item){
        int mo = N % NUMBER;
        if(mo == 0){
            N = 0;
            pushItemToBottom(firstStack, secondStack, item);
        }else if(mo == 1){
            pushItemToBottom(secondStack, threeStack, item);
        }else if(mo == 2){
            pushItemToBottom(threeStack, firstStack, item);
        }
        N++;
    }

    private void pushItemToBottom(Stack<Item> stack, Stack<Item> tempStack, Item item){
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            tempStack.push(stack.pop());
        }
        stack.push(item);
        for (int i = 0; i < stackSize; i++) {
            stack.push(tempStack.pop());
        }
    }


    public Item pop(){
        int firstN = firstStack.size();
        int secondN = secondStack.size();
        int threeN = threeStack.size();
        Item item = null;
        if(firstN >= secondN && firstN >= threeN){
            item = firstStack.pop();
        }else if (secondN >= threeN){
            item = secondStack.pop();
        }else {
            item = threeStack.pop();
        }
        autoRe();
//        N--;
        return item;
    }

    private void autoRe(){
        if(firstStack.size()<secondStack.size()){
            firstStack.push(secondStack.pop());
        }
        if(secondStack.size() < threeStack.size()){
            secondStack.push(threeStack.pop());
        }
    }

    public boolean hasNext(){
        int total = firstStack.size() + secondStack.size() + threeStack.size();
        return total > 0;
    }

    public static void main(String[] args) {
        QueueWithStacks<String> q = new QueueWithStacks<>();
        q.push("aaa");
        q.push("bbb");
        q.push("ccc");
        String r = q.pop();
        System.out.println("r: " + r);
        q.push("ddd");
        q.push("eee");
        System.out.println("r:"+q.pop());
        q.push("fff");

        while (q.hasNext()){
            System.out.println(q.pop());
        }
    }


}
