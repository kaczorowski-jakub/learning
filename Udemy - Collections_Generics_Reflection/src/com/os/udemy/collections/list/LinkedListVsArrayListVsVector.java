package com.os.udemy.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListVsArrayListVsVector {
    public static void main(String[] args) {

        System.out.println("Adding at the beginning");
        long start = System.currentTimeMillis();
        addAtTheBeginning(new ArrayList<Integer>());
        long stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        addAtTheBeginning(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        addAtTheBeginning(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));

        // ------------------------
        System.out.println("\nAdding at the end");
        start = System.currentTimeMillis();
        addAtTheEnd(new ArrayList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        addAtTheEnd(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        addAtTheEnd(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));

        // ------------------------
        System.out.println("\nAdding in the middle");
        start = System.currentTimeMillis();
        addInTheMiddle(new ArrayList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        addInTheMiddle(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        addInTheMiddle(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));

        // ------------------------
        System.out.println("\nRemoving at the beginning");
        start = System.currentTimeMillis();
        removeAtTheBeginning(new ArrayList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        removeAtTheBeginning(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        removeAtTheBeginning(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));
        
        // ------------------------
        System.out.println("\nRemoving at the end");
        start = System.currentTimeMillis();
        removeAtTheEnd(new ArrayList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        removeAtTheEnd(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        removeAtTheEnd(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));
        
        // ------------------------
        System.out.println("\nRemoving in the middle");
        start = System.currentTimeMillis();
        removeInTheMiddle(new ArrayList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("ArrayList: " + (stop - start));

        start = System.currentTimeMillis();
        removeInTheMiddle(new LinkedList<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("LinkedList: " + (stop - start));
        
        start = System.currentTimeMillis();
        removeInTheMiddle(new Vector<Integer>());
        stop = System.currentTimeMillis();
        System.out.println("Vector: " + (stop - start));
    }

    private static void addAtTheBeginning(List<Integer> list) {
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
    }

    private static void addAtTheEnd(List<Integer> list) {
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }

    private static void addInTheMiddle(List<Integer> list) {
        for (int i = 0; i < 100000; i++) {
            if (list.size() == 0) {
                list.add(i);
            } else {
                list.add(list.size() / 2, i);
            }

        }
    }

    private static void createList(List<Integer> list) {
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }

    private static void removeAtTheBeginning(List<Integer> list) {
        createList(list);
        while (list.size() > 0) {
            list.remove(0);
        }
    }

    private static void removeAtTheEnd(List<Integer> list) {
        createList(list);
        while (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }
    
    private static void removeInTheMiddle(List<Integer> list) {
        createList(list);
        while (list.size() > 0) {
            list.remove(list.size()/2);
        }
    }
}
