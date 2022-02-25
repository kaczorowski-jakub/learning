package com.os.udemy.collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashMapSpying {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        loadFactor();

    }

    private static void loadFactor() throws IllegalArgumentException, IllegalAccessException {
        Map<String, Integer> map = new HashMap<>();
        
        System.out.println("Empty");
        printMap(map);
        
        map.put("T1", 1);
        map.put("T2", 2);
        map.put("T3", 3);
        map.put("T4", 4);
        map.put("T5", 5);
        map.put("T6", 6);
        map.put("T7", 7);
        map.put("T8", 7);
        map.put("T9", 7);
        map.put("T10", 7);
        map.put("T11", 7);
        map.put("T12", 7);
        System.out.println("Reaching max");
        printMap(map);
        map.put("T13", 7);
        System.out.println("After resizing");
        printMap(map);

    }

    private static void printMap(Map<?, ?> map) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : map.getClass().getDeclaredFields()) {
            switch (field.getName()) {
            case "loadFactor":
                field.setAccessible(true);
                System.out.println("Load factor: " + field.get(map).toString());
                break;
            case "threshold":
                field.setAccessible(true);
                System.out.println("threshold: " + field.get(map).toString());
                break;
            }
        }
    }
}
