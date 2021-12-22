package com.os.udemy.multithreading.creating;

public class ThreadUncoughtExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Inside " + Thread.currentThread().getName());
            throw new RuntimeException("ERRROR !!!");
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(
                        "A critical error happened in thread: " + t.getName() + " the error is " + e.getMessage());

            }
        });
        thread.setName("Misbehaving thread");
        thread.start();
    }
}
