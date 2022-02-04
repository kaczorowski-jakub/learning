package com.os.udemy.multithreading.communication;

public class SimpleCommunication {
    public static void main(String[] args) {
        
        SharedClass sc = new SharedClass();
        
        for (int i = 0 ; i < 10 ; i ++) {
            new Thread(() -> {
                sc.waitUntiComplete();
            }).start();
        }
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sc.complete();
        }
        
    }
    
    public static class SharedClass {
        private boolean isComplete = false;
        
        public synchronized void waitUntiComplete() {
            while (isComplete == false) {
                System.out.println(Thread.currentThread().getName() + " is waitng");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
            }
        }
        
        public synchronized void complete() {
            isComplete = true;
            notifyAll();
        }
    }
}
