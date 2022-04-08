package com.os.udemy.collections.collectionsClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(14,32,55,43,15,56,977);
        
        System.out.println("Original: " + list);
        Collections.reverse(list);
        System.out.println("Reversed: " + list);
        System.out.println("Min: " + Collections.min(list));
        System.out.println("Max: " + Collections.max(list));
        Collections.shuffle(list);
        System.out.println("Shuffled: " + list);
        Collections.rotate(list, 1);
        System.out.println("Rotated + 1: " + list);
        Collections.rotate(list, 2);
        System.out.println("Rotated + 2: " + list);
        Collections.replaceAll(list, 14, 10);
        System.out.println("Replaced 14 with 10: " + list);
    }
}
