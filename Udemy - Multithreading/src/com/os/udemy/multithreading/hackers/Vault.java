package com.os.udemy.multithreading.hackers;

public class Vault {
    
    private final int password;
    public final static int MAX_PASSWORD = 9999;
    
    public Vault(int password) {
        this.password = password;
    }
    
    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return password == guess;
    }
}
