package com.os.udemy.collections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * 
 * @author jakub.kaczorowski
 *
 */
public class DequeTest {
    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<String>();
        queue1.addAll(Arrays.asList("ALA", "MA", "KOTA", "A", "KOT","MA", "ALE"));
        queue1.offer("TEST");
        queue1.offer("1000");
        
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }
        System.out.println(queue1);
        
        
        // works as a stack but it's not synchronized
        Deque<String> queue2 = new ArrayDeque<String>();
        queue2.push("1");
        queue2.push("2");
        queue2.push("3");
        queue2.push("4");
        
        // get doesn't remove any item
        System.out.println(queue2.getFirst());
        
        while (!queue2.isEmpty()) {
            System.out.println(queue2.pop());
        }
    }
}
