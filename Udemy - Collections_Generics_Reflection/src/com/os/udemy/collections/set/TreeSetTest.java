package com.os.udemy.collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * almost all of the operations have P(logN)
 * 
 * @author jakub.kaczorowski
 *
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>();

        set.add(12);
        set.add(1);
        set.add(9);
        set.add(120);
        set.add(87);
        set.add(55);

        System.out.print("Full Set: ");
        for (Integer i : set) {
            System.out.print(i + ",");
        }

        System.out.print("\nSubSet (1-80): ");
        Set<Integer> subSet = set.subSet(1, 80);
        for (Integer i : subSet) {
            System.out.print(i + ",");
        }

        System.out.print("\nTailSet (50): ");
        Set<Integer> tailSet = set.tailSet(55);
        for (Integer i : tailSet) {
            System.out.print(i + ",");
        }
        
        System.out.print("\nHeadSet (50): ");
        Set<Integer> headSet = set.headSet(55);
        for (Integer i : headSet) {
            System.out.print(i + ",");
        }
        
        System.out.print("\nFirst: " + set.first());
        System.out.print("\nLast: " + set.last());
        
        SortedSet<Integer> setRev = new TreeSet<>(Comparator.reverseOrder());
        setRev.addAll(set);
        System.out.print("\nRev First: " + setRev.first());
        System.out.print("\nRev Last: " + setRev.last());
        
        
    }
}
