package com.os.udemy.multithreading.creating;

public class ThreadByThread {
    public static void main(String[] args) {
        NewThread thread = new NewThread();
        thread.setName("NewThread");
        thread.start();
    }
    
    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + getName());
        }
    }
}
