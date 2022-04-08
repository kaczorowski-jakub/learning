package com.os.udemy.collections.collectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollections {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        
        Thread t1 = new Thread(() -> {
           for (int i = 0 ; i < 100000 ; i++) {
               list.add(i);
           }
        });
        t1.start();
        
        Thread t2 = new Thread(() -> {
            for (int i = 0 ; i < 100000 ; i++) {
                list.add(i);
            }
         });
         t2.start();
         
         t1.join();
         t2.join();
         System.out.println("Unsynch List size: " + list.size());   // this should return different than 200000 values
         
         Thread.sleep(1000);
         
         List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
         Thread t3 = new Thread(() -> {
             for (int i = 0 ; i < 100000 ; i++) {
                 list2.add(i);
             }
          });
          t3.start();
          
          Thread t4 = new Thread(() -> {
              for (int i = 0 ; i < 100000 ; i++) {
                  list2.add(i);
              }
           });
           t4.start();
           
           t3.join();
           t4.join();
           System.out.println("Synch List size: " + list2.size());
         
    }
}
