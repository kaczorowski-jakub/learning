package com.os.udemy.multithreading.datasharing;

public class SynchronizationMethods {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread icThread = new IncrementingThread(inventoryCounter);
        DecrementingThread dcThread = new DecrementingThread(inventoryCounter);
        
        icThread.start();
        dcThread.start();
        
        icThread.join();
        dcThread.join();
        
        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class IncrementingThread extends Thread {

        private final InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.inc();
            }
        }
    }

    public static class DecrementingThread extends Thread {

        private final InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.dec();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;

        public synchronized void inc() {
            items++;
        }

        public synchronized void dec() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }
}
