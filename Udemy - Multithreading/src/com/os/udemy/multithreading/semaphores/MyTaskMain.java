package com.os.udemy.multithreading.semaphores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTaskMain {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Reader reader = new Reader(resource);
        Checker checker = new Checker(resource, "YOYO");

        checker.start();
        reader.start();
    }

    public static class Checker extends Thread {
        final private Resource resource;
        final String secret;

        public Checker(Resource resource, String secret) {
            this.resource = resource;
            this.secret = secret;
        }

        @Override
        public void run() {
            while (true) {
                // we need the lock for shared variable - userName
                resource.getLock().lock();
                try {
                    while (resource.getUserName() == null || resource.getUserName().isEmpty()) {
                        try {
                            resource.getCondition().await(); // unlock the locks and wait until signalled
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (resource.getUserName().equals(secret)) {
                        System.out.println("Congrats, you found it: " + resource.getUserName());
                        return;
                    } else {
                        System.out.println("Wrong! Try again");
                        resource.setUserName("");
                    }
                } finally {
                    resource.getLock().unlock();
                }
            }
        }
    }

    public static class Reader extends Thread {
        final private Resource resource;

        public Reader(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                // we need the lock for shared variable - userName
                resource.getLock().lock();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String name = reader.readLine();
                    resource.setUserName(name);
                    resource.getCondition().signal(); // wakes up a single thread waiting on the condition variable
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    resource.getLock().unlock();
                }
                
                // time to check again
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class Resource {
        final private Lock lock = new ReentrantLock();
        final private Condition condition = lock.newCondition();
        private String userName;

        public Lock getLock() {
            return lock;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }
}
