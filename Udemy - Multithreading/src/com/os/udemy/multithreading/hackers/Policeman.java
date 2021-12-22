package com.os.udemy.multithreading.hackers;

public class Policeman extends Thread {
    @Override
    public void run() {
        for (int i = 10 ; i > 0 ; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i);
        }
        
        System.out.println("Game over for you hackers");
        System.exit(0);
    }
}
