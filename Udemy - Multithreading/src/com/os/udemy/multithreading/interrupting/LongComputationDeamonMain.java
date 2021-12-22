package com.os.udemy.multithreading.interrupting;

import java.math.BigInteger;

public class LongComputationDeamonMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000"), new BigInteger("1000000000")));
        thread.setDaemon(true); // if set the threads will exit when the main thread has exited, // it has to be set before start - otherwise it won't work
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        System.out.println("END");
    }
    
    private static class LongComputationTask implements Runnable {
        
        private final BigInteger base;
        private final BigInteger power;
        
        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
        
        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }
        
        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO ; i.compareTo(power) != 0 ; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
                System.out.println(result);
            }
            return result;
        }
    }
}
