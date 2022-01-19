package com.os.udemy.multithreading.datasharing;

import java.util.Random;

public class Metric {
    
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic bl1 = new BusinessLogic(metrics);
        BusinessLogic bl2 = new BusinessLogic(metrics);
        MetricsPrinter mp = new MetricsPrinter(metrics);
        
        bl1.start();
        bl2.start();
        mp.start();
    }
    
    public static class MetricsPrinter extends Thread {
        private Metrics metrics;
        
        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }
        
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                double currentAverage = metrics.getAvg();
                System.out.println("average is: " + currentAverage);
            }
        }
    }
    
    public static class BusinessLogic extends Thread {
        private Metrics metrics;
        private Random random = new Random();
        
        public BusinessLogic(Metrics metrics) {
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
                
                long end = System.currentTimeMillis();
                
                metrics.addSample(end - start);
            }
        }
    }
    
    public static class Metrics {
        private int count;
        private volatile double avg = 0.0;
        
        public synchronized void addSample(long sample) {
            double currentSum = avg * count;
            count++;
            avg = (currentSum + sample) / count;
        }
        
        public double getAvg() {
            return avg;
        }
    }
}
