package com.os.udemy.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet has keys only
 * There is an array under the hood of initial capacity = 16 and load factor = 0.75
 * It uses HashMap under the hood with dummy object as the value of each entry
 * 
 * One null value
 * 
 * No Order
 * 
 * O(1) - when no collisions
 * 
 * LinkedList for elements in the same bucket which will can be converted to RB tree
 * 
 * @author jakub.kaczorowski
 *
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        
        // one null key
        set1.add(null);
        set1.add("VAL");
        set1.add("TEST");
        set1.add("BEST");
        set1.add("FRIEND");
        
        // iterable
        System.out.println("SET1:");
        for (String s : set1) {
            System.out.println(s);
        }
        
        Set<String> set2 = new HashSet<>();
        set2.add("VAL");
        set2.add("FRIEND");
        
        Set<String> set3 = new HashSet<>();
        set3.add("FRIEND");
        
        System.out.println("---\nSET3:");
        set2.retainAll(set3);   // only the common keys
        System.out.println(set3);
        System.out.println(set2.containsAll(set3));
        System.out.println(set3.containsAll(set2));
    }
}
