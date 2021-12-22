package com.os.udemy.multithreading.task;

import java.util.List;

public class MultiExecutor {

    private final List<Runnable> tasks;

    /* 
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        for (Runnable r : this.tasks) {
            new Thread(r).start();
        }
    }
}
