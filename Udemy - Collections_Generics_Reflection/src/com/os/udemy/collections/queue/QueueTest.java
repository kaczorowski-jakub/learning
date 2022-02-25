package com.os.udemy.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue is a FIFO structure first in first out
 * @author jakub.kaczorowski
 *
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();  // because LinkedList implements Deque
        
        queue.offer(123);
        queue.add(321);
        
        // queue is iterable
        System.out.println("Printing QUEUE");
        for (Integer i : queue) {
            System.out.println(i);
        }
        
        // poll will remove the item
        System.out.println("Polling QUEUE");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        
        // peek will always return the first element on the list without removing it
        queue.add(400);
        queue.add(500);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        
    }
}
