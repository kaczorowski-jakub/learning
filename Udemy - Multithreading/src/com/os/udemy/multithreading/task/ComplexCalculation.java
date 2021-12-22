package com.os.udemy.multithreading.task;

import java.math.BigInteger;

public class ComplexCalculation {
    
    public static void main(String[] args) {
        ComplexCalculation cc = new ComplexCalculation();
        try {
            System.out.println(cc.calculateResult(new BigInteger("1986"), new BigInteger("43"), new BigInteger("42"), new BigInteger("15")));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        PowerCalculatingThread pcThread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread pcThread2 = new PowerCalculatingThread(base2, power2);
        pcThread1.setDaemon(true);
        pcThread2.setDaemon(true);
        pcThread1.start();
        pcThread2.start();
        pcThread1.join(2000);
        pcThread2.join(2000);
        
        result = pcThread1.getResult().add(pcThread2.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
           for (BigInteger i = BigInteger.ZERO; !i.equals(power); i = i.add(BigInteger.ONE)) {
               result = result.multiply(base);
           }
        }
    
        public BigInteger getResult() { return result; }
    }
}
