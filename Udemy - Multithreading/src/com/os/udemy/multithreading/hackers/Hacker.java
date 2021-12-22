package com.os.udemy.multithreading.hackers;

public abstract class Hacker extends Thread {
    protected Vault vault;
    
    public Hacker(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(Thread.MAX_PRIORITY);
    }
    
    @Override
    public synchronized void start() {
        System.out.println("Starting thread " + this.getName());
        super.start();
    }
}
