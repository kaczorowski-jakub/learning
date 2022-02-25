package com.os.udemy.collections.list;

import java.util.ArrayList;
import java.util.List;

import com.os.udemy.collections.CollectionSpy;

/**
 * getting element is very fast because it uses indexes ArrayList<Integer> 0 34
 * 1 -12 2 2 3 300 4 -45
 * 
 * get(0) getting is O(1) because we are moving directly on the memory block
 * using index ----> random access The data is allocated next to each other
 * memory address = array's address + (index * data size (4 bytes - ref to
 * object))
 * 
 * it is more or less equal to [] -> int[]
 * 
 * adding at the end is also fast O(1) 
 * adding at the arbitrary position is slow O(N) - we have to shift the items
 * 
 * removing the last element is fast O(1) 
 * removing the arbitrary position element is slow O(N)
 * 
 * 
 * default size = 10 when it grows i grows size * 2 on resizing it is O(N)
 * 
 * @author jakub.kaczorowski
 *
 */
public class ArrayListTest {

    public static void main(String[] args) {
        udemyExercise();
        // addingAtArbirtary();
        // testAddingElementsToCheckResizing();
    }

    private static void udemyExercise() {
        List<Integer> list1 = new ArrayList<>(); // default capacity of 10
        List<Integer> list2 = new ArrayList<>(100); // user selection capacity
        ArrayList<Integer> list3 = new ArrayList<Integer>();

        list1.add(101);
        list1.add(102);
        list1.add(103);
        list1.add(104);
        printList(list1);

        // O(N) because of shifting
        list1.add(3, 109);

        // because of Iterable
        for (Integer i : list1) {
            System.out.println(i);
        }

        System.out.println("---");
        System.out.println("toArray");
        Integer[] myArr = list1.toArray(new Integer[] {});
        for (int i : myArr) {
            System.out.println(i);
        }
        
        System.out.println("---");
        System.out.println(list1.contains(101));    // O(N)
        System.out.println(list1.contains(111));    // O(N)
        
        // replacing element at index 
        System.out.println(list1);
        list1.set(1, 500);
        System.out.println(list1);  // O(1)
        
        // capacity
        System.out.println("---");
        System.out.println("Capacity:");
        CollectionSpy.printCollection(list3);
        list3.ensureCapacity(100);
        CollectionSpy.printCollection(list3);

    }

    private static void addingAtArbirtary() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        System.out.println("Initial:");
        printList(arrayList);
        System.out.println("---");

        System.out.println("After adding:");
        arrayList.add(5, 101);
        printList(arrayList);
    }

    private static void testAddingElementsToCheckResizing() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        for (int i = 0; i < 22; i++) {
            long startTime = System.currentTimeMillis();
            addToResize(arrayList);
            long stopTime = System.currentTimeMillis();
            System.out.println(
                    "Iteration " + i + " took " + (stopTime - startTime) + "ms, and the size is " + arrayList.size());
        }
    }

    private static void addToResize(List<Integer> arrayList) {
        final int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
    }

    private static void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ", val=" + list.get(i));
        }
    }

}
