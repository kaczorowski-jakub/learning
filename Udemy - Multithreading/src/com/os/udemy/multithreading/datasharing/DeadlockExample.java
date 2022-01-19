package com.os.udemy.multithreading.datasharing;

import java.util.Random;

public class DeadlockExample {
    
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainA = new Thread(new TrainA(intersection));
        Thread trainB = new Thread(new TrainB(intersection));
        
        trainA.start();
        trainB.start();
    }
    
    public static class TrainB implements Runnable {
        
        private Intersection intersection;
        private Random random = new Random();
        
        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }
        
        @Override
        public void run() {
            while(true) {
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                intersection.takeRoadB();
            }
        }
        
    }
    
    public static class TrainA implements Runnable {
        
        private Intersection intersection;
        private Random random = new Random();
        
        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }
        
        @Override
        public void run() {
            while(true) {
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                intersection.takeRoadA();
            }
        }
        
    }
    
    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
        
        public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

                synchronized (roadA) {
                    System.out.println("Train is passing through road B");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

}
