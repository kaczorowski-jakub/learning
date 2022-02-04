package com.os.udemy.multithreading.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackLocks {
    
    public static void main(String[] args) throws InterruptedException {
        StandardStack<Integer> stack = new StandardStack<>();
        Random random = new Random();
        
        for (int i = 0 ; i < 100000 ; i ++) {
            stack.push(random.nextInt());
        }
        
        List<Thread> threads = new ArrayList<>();
        
        int pushingThreads = 2;
        int poppingThreads = 2;
        
        for (int i = 0 ; i < pushingThreads ; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    stack.push(random.nextInt());
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }
        
        for (int i = 0 ; i < poppingThreads ; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    stack.pop();
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
        
        Thread.sleep(3000);
        
        System.out.println("Number of operations: " + stack.getCounter());
    }
    
    public static class StandardStack<T> {
        private StackNode<T> head;
        private int counter = 0;
        
        public synchronized void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);
            newHead.next = head;
            head = newHead;
            counter++;
        }
        
        public synchronized T pop() {
            if (head == null) {
                counter++;
                return null;
            }
            
            T value = head.value;
            head = head.next;
            counter++;
            return value;
        }
        
        public int getCounter() {
            return counter;
        }
    }
    
    private static class StackNode<T> {
        public T value;
        public StackNode<T> next;
        
        public StackNode(T value) {
            this.value = value;
        }
    }
}
