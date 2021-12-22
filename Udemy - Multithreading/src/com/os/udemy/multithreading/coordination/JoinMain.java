package com.os.udemy.multithreading.coordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        //List<Long> intNumbers = Arrays.asList(1L, 3435L, 35435L, 2324L, 5656L, 23L, 2435L, 5566L);
        List<Long> intNumbers = Arrays.asList(1000000000000L, 3435L, 35435L, 2324L, 5656L, 23L, 2435L, 5566L);
        
        List<FactorialThread> threads = new ArrayList<>();
        for (long inputNumber : intNumbers) {
            FactorialThread ft = new FactorialThread(inputNumber);
            threads.add(ft);
            ft.setDaemon(true); // it has to be set before start - otherwise it won't work
            ft.start();
            ft.join(2000);  // it has to be after start - otherwise it won't work and the result will be incomplete
        }
        
        for (int i = 0 ; i < threads.size() ; i++) {
            FactorialThread ft = threads.get(i);
            if (ft.isFinished()) {
                System.out.println("Factorial of " + ft.getInputNumber() + " is " + ft.getResult());
            } else {
                System.out.println("Factorial of " + ft.getInputNumber() + " is still in progress");
            }
        }
    }
    
    private static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;
        
        public FactorialThread(long input) {
            this.inputNumber = input;
        }
        
        @Override
        public void run() {
            this.result = factorial(this.inputNumber);
            this.isFinished = true;
        }
        
        private BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;
            
            for (long i = n ; i > 0 ; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }
        
        public boolean isFinished() {
            return isFinished;
        }
        
        public BigInteger getResult() {
            return result;
        }
        
        public long getInputNumber() {
            return inputNumber;
        }
    }
}
