package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe46;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Queue;
import com.hef.algorithms.fundamentals.bags_queues_stacks.Stack;

/**
 * Catenable queues, stacks, or steques. Add an extra operation catenation that (destructively) concatenates two queues,
 * stacks or steques(see Exercise1.3.32). Hint: use a circular linked list, maintaining a pointer to the last item.
 * @Date 2019-04-25
 * @Author lifei
 */
public class CatenableOperation<Item> {

    public Stack<Item> concatenate(Stack<Item> first,Stack<Item> second){
        CircleLink<Item> circleLink = createCircleLink(first, second);
        Stack<Item> generateStack = new Stack<>();
        for (Item item :
                circleLink) {
            generateStack.push(item);
        }

        Stack<Item> result = new Stack<>();
        for (Item it :
                generateStack) {
            result.push(it);
        }
        circleLink = null;
        generateStack = null;
        return result;
    }


    public Queue<Item> concatenate(Queue<Item> first, Queue<Item> second){
        CircleLink<Item> circleLink = createCircleLink(first, second);
        Queue<Item> result = new Queue<>();
        for (Item item :
                circleLink) {
            result.enqueue(item);
        }
        return result;
    }

    private CircleLink<Item> createCircleLink(Iterable<Item> first, Iterable<Item> second){
        CircleLink<Item> circleLink = new CircleLink<>();
        for (Item item:
                first) {
            circleLink.push(item);
        }
        for (Item item :
                second) {
            circleLink.push(item);
        }
        return circleLink;
    }

    public static void main(String[] args) {
        Stack<String> stack01 = new Stack<>();
        stack01.push("aaa");
        stack01.push("bbb");
        stack01.push("ccc");
        Stack<String> stack02 = new Stack<>();
        stack02.push("s01");
        stack02.push("s02");
        stack02.push("s03");
        Queue<String> queue01 = new Queue<>();
        queue01.enqueue("aaa");
        queue01.enqueue("bbb");
        queue01.enqueue("ccc");
        Queue<String> queue02 = new Queue<>();
        queue02.enqueue("aaa");
        queue02.enqueue("bbb");
        queue02.enqueue("ccc");

        CatenableOperation<String> catenableOperation = new CatenableOperation<>();
        Stack<String> result = catenableOperation.concatenate(stack01, stack02);
        printIteratble("stack",stack01, stack02, result);

        Queue<String> que = catenableOperation.concatenate(queue01, queue02);
        printIteratble("queue", queue01, queue02, que);

    }

    private static void printIteratble(String description, Iterable<String> first, Iterable<String> second, Iterable<String> total){
        System.out.println(description+ ":");
        for (String s :
                first) {
            System.out.printf("%s%s"," ",s);
        }
        System.out.println();
        for (String s :
                second) {
            System.out.printf("%s%s"," ",s);
        }

        System.out.println();
        for (String s :
                total) {
            System.out.printf("%s%s"," ",s);
        }
        System.out.println();

    }

}
