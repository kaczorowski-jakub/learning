package com.os.udemy.collections;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class CollectionSpy {

    public static void printCollection(Collection<?> collection) {
        try {
            for (Field field : collection.getClass().getDeclaredFields()) {
                switch (field.getName()) {
                case "loadFactor":
                    field.setAccessible(true);
                    System.out.println("Load factor: " + field.get(collection).toString());
                    break;
                case "threshold":
                    field.setAccessible(true);
                    System.out.println("threshold: " + field.get(collection).toString());
                    break;
                case "minCapacity":
                    field.setAccessible(true);
                    System.out.println("minCapacity: " + field.get(collection).toString());
                    break;
                case "elementData":
                    field.setAccessible(true);
                    Object[] arr = (Object[]) field.get(collection);
                    System.out.println("elementData: " + arr.length);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printMap(Map<?, ?> map) throws IllegalArgumentException, IllegalAccessException {
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
            case "minCapacity":
                field.setAccessible(true);
                System.out.println("minCapacity: " + field.get(map).toString());
                break;
            case "elementData":
                field.setAccessible(true);
                Object[] arr = (Object[]) field.get(map);
                System.out.println("elementData: " + arr.length);
                break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void fillMap(Map map, int max) {
        for (int i = 0; i < max; i++) {
            map.put(i, i);
        }
    }
}
