package com.os.udemy.multithreading.task;

import java.util.Random;

public class MinMaxMetrics {

    private volatile long minValue;
    private volatile long maxValue;

    public MinMaxMetrics() {
        minValue = -1;
        maxValue = -1;
    }

    public static void main(String[] args) {
        MinMaxMetrics mmm = new MinMaxMetrics();
        BusinessLogic bl1 = new BusinessLogic(mmm);
        BusinessLogic bl2 = new BusinessLogic(mmm);
        MinReader minR = new MinReader(mmm);
        MaxReader maxR = new MaxReader(mmm);
        
        bl1.start();
        bl2.start();
        minR.start();
        maxR.start();
    }
    
    private static class MinReader extends Thread {
        private MinMaxMetrics metrics;
        
        public MinReader(MinMaxMetrics metrics) {
            this.metrics = metrics;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Min is: " + metrics.getMin());
            }
        }
    }
    
    private static class MaxReader extends Thread {
        private MinMaxMetrics metrics;
        
        public MaxReader(MinMaxMetrics metrics) {
            this.metrics = metrics;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Max is: " + metrics.getMax());
            }
        }
    }
    
    private static class BusinessLogic extends Thread {
        private MinMaxMetrics metrics;
        private Random random = new Random();

        public BusinessLogic(MinMaxMetrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long stop = System.currentTimeMillis();

                metrics.addSample(stop - start);
            }
        }

    }

    public synchronized void addSample(long sample) {
        if (sample < minValue || minValue == -1) {
            minValue = sample;
        }
        if (sample > maxValue || maxValue == -1) {
            maxValue = sample;
        }
    }

    public long getMin() {
        return minValue;
    }

    public long getMax() {
        return maxValue;
    }
}
