package com.os.udemy.multithreading.creating;

public class ThreadByRunnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(ThreadByRunnable::thread1);
        thread.setName("A new worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("we are in thread " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("we are in thread " + Thread.currentThread().getName() + " after starting a new thread");
        
        Thread.sleep(1000);
    }
    
    private static void thread1() {
        System.out.println("We are now in thread " + Thread.currentThread().getName());
        System.out.println("Curren thread priority is " + Thread.currentThread().getPriority());
    }
    
}
