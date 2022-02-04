package com.os.udemy.multithreading.semaphores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProducerConsumerExample {
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        
        Thread producer = new Thread(() -> {
            while(true) {
                try {
                    // simulate production time
                    Thread.sleep(50);
                    queue.produce();
                    
                } catch (InterruptedException e) {
                    
                }
            }
        });
        
        Thread consumer1 = new Thread(() -> {
            while(true) {
                try {
                    // simulate consumption time
                    Thread.sleep(20);
                    queue.consume();
                } catch (InterruptedException e) {
                    
                }
            }
        });
        
        Thread consumer2 = new Thread(() -> {
            while(true) {
                try {
                    // simulate consumption time
                    Thread.sleep(20);
                    queue.consume();
                } catch (InterruptedException e) {
                    
                }
            }
        });
        
        consumer1.start();
        consumer2.start();
        producer.start();
        
        
    }
    
    public static class Queue {
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);
        Item item = null;
        
        void produce() throws InterruptedException {
            empty.acquire();
            item = new Item(generateName());
            System.out.println("Item: " + item + " produced");
            full.release();
        }
        
        void consume() throws InterruptedException {
            full.acquire();
            System.out.println("Item: " + item + " consumed by " + Thread.currentThread().getName());
            empty.release();
        }
        
        private String generateName() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int size = random.nextInt(50);
            
            for (int i = 1 ; i <= size ; i++) {
                sb.append((char)(random.nextInt(50) + 48));
            }
            
            return sb.toString();
        }
    }
    
    public static class Item {
        private String name;
        
        private Item(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
}
