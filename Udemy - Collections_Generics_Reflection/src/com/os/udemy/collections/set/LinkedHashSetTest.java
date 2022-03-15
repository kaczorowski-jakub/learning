package com.os.udemy.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * it extends HashSet so it also has capacity and load factor
 * it is based on LinkedHashMap
 * it preserves the order
 * @author jakub.kaczorowski
 *
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Adam");
        set1.add("Kevin");
        set1.add("Daniel");
        set1.add("Joe");
        set1.add("Step");

        // no order
        System.out.println("Set1");
        for (String s : set1) {
            System.out.println(s);
        }

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("Adam");
        set2.add("Kevin");
        set2.add("Daniel");
        set2.add("Joe");
        set2.add("Step");

        // order
        System.out.println("---\nSet2");
        Iterator<String> iterator = set2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
