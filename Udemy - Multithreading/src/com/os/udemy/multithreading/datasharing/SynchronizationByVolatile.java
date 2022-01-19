package com.os.udemy.multithreading.datasharing;

public class SynchronizationByVolatile {

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
    
    /**
     * This will not work because volatile is atomic in terms of
     * operation of write/read but in case of ++ we have more than one operation
     * we have read, we have increment and we have write. In that case volatile won't help
     * Only assignments are atomic
     * @author jakub.kaczorowski
     *
     */
    private static class InventoryCounter {
        private volatile int items = 0;
        private Object lock = new Object();

        public void inc() {
            items++;
        }

        public void dec() {
            items--;
        }

        public int getItems() {
            synchronized (lock) {
                return items;
            }
        }
    }
}
