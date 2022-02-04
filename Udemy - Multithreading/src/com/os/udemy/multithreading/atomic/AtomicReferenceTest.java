package com.os.udemy.multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        test1();
        test2();
    }
    
    private static void test1() {
        String oldName = "old name";
        String newName = "new name";
        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
        
        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("New value is " + atomicReference.get());
        } else {
            System.out.println("Nothing happened");
        }
    }
    
    private static void test2() {
        String oldName = "old name";
        String newName = "new name";
        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
        
        atomicReference.set("Unexpected name");
        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("New value is " + atomicReference.get());
        } else {
            System.out.println("Nothing happened");
        }
    }
}
