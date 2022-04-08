package com.os.udemy.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapVsHashMap {

    private static final int SIZE = 1_000_000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        adding(new HashMap<>());
        long stop = System.currentTimeMillis();
        System.out.println("Hash map adding: " + (stop - start));
        start = System.currentTimeMillis();
        adding(new TreeMap<>());
        stop = System.currentTimeMillis();
        System.out.println("Tree map adding: " + (stop - start));
        
        start = System.currentTimeMillis();
        getting(new HashMap<>());
        stop = System.currentTimeMillis();
        System.out.println("Hash map getting: " + (stop - start));
        start = System.currentTimeMillis();
        getting(new TreeMap<>());
        stop = System.currentTimeMillis();
        System.out.println("Tree map getting: " + (stop - start));
    }

    private static void adding(Map<Integer, String> map) {
        for (int i = 0; i < SIZE; i++) {
            map.put(i, "VAL" + i);
        }
    }

    private static void getting(Map<Integer, String> map) {
        adding(map);
        for (int i = 0 ; i < SIZE ; i++) {
            map.get(i);
        }
    }
}
