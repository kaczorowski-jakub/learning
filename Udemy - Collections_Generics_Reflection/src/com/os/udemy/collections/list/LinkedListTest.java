package com.os.udemy.collections.list;

import java.util.LinkedList;

/**
 * LinkedList is to insert and remove items ASAP
 * It is based on nodes which are wired with each other
 * 
 * it has a pointer at the beginning and at the end
 * 
 * it takes more space in the memory because it stores data and pointers (next and prev)
 * 
 * the elements are not stored next to each other in the memory
 * 
 * insert at the beginning and end are fast O(1)
 * removing at the beginning and end are fast O(1)
 * 
 * no need to resize any array because there isn't any
 * 
 * @author jakub.kaczorowski
 *
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(100);
        list1.add(101);
        list1.add(102);
        list1.add(103);
        System.out.println("As LinkedList");
        System.out.println(list1);
        System.out.println("First: " + list1.getFirst());
        System.out.println("Last: " + list1.getLast());
        System.out.println("Element at 1: " + list1.get(1));
        //System.out.println(list1.get(4)); //java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
        
        // iterable
        for (int i : list1) {
            System.out.println(i);
        }
        
        list1.addLast(500);
        list1.addFirst(-100);
        System.out.println(list1);
        
        
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);
        
    }
}
