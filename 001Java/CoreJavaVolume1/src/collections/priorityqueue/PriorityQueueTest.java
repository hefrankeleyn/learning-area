package collections.priorityqueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * This program demonstrates the use of a priority queue.
 * @version 1.0 2019-01-26
 * @author Li Fei
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(2000, 12, 9));
        pq.add(LocalDate.of(2001, 11, 1));
        pq.add(LocalDate.of(2012, 1, 3));
        pq.add(LocalDate.of(2003, 11, 10));
        System.out.println("Iterating over elements....");

        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements");
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
    
}