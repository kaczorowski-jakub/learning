package com.os.udemy.collections.map;

import java.util.Hashtable;

import com.os.udemy.collections.CollectionSpy;

/**
 * Hashtable is synchronized
 * 
 * 
 * @author jakub.kaczorowski
 *
 */
public class HashTableTest {
    public static void main(String[] args) {
        basic();
        resizing();
    }

    private static void basic() {
        Hashtable<Integer, String> hashtable1 = new Hashtable<>();

        hashtable1.put(1, "AAAA");
        hashtable1.put(2, "BBBB");
        hashtable1.put(3, "CCCC");
        System.out.println(hashtable1);
        hashtable1.put(2, "DD");
        System.out.println(hashtable1);
        try {
            hashtable1.put(null, "NUll key is not allowed");
        } catch (NullPointerException e) {
            System.out.println("NUll key is not allowed");
        }
        try {
            hashtable1.put(100, null);
        } catch (NullPointerException e) {
            System.out.println("Null value is not allowed");
        }
    }

    private static void resizing() {
        Hashtable<String, String> hashtable1 = new Hashtable<>();
        Hashtable<String, String> hashtable2 = new Hashtable<>(30);
        Hashtable<String, String> hashtable3 = new Hashtable<>(30, 0.1f);

        long start, stop;

        System.out.println("Default: C=11, LF=0.75");
        start = System.currentTimeMillis();
        CollectionSpy.fillMap(hashtable1, 1000000);
        stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));

        System.out.println("Custom2: C=30, LF=0.75");
        start = System.currentTimeMillis();
        CollectionSpy.fillMap(hashtable2, 1000000);
        stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));

        System.out.println("Custom3: C=30, LF=0.1");
        start = System.currentTimeMillis();
        CollectionSpy.fillMap(hashtable3, 1000000);
        stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));
    }
}
