package com.os.udemy.collections.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Java uses quick sort to sort primitive types Java uses merge sort to sort
 * reference types
 * 
 * @author jakub.kaczorowski
 *
 */
public class Basics {
    public static void main(String[] args) {
        arraySroting();
        collectionSorting();
    }
    
    
    private static void collectionSorting() {
        List<String> list = new ArrayList<>(Arrays.asList("Kevin", "Daniel", "Katy", "Ana", "Joe", "Adam"));
        System.out.println("\nCollections:");
        
        Collections.sort(list);
        System.out.println("ASC: " + list);
        
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("DESC: " + list);
        
    }
    
    private static void arraySroting() {
        int[] nums = { 1, 10, 5, 2, -5, 12, 14, 0, 1, 2 };

        System.out.print("ASC order: ");
        Arrays.sort(nums);
        for (int n : nums) {
            System.out.print(n + ",");
        }

        System.out.print("\nDESC order: ");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + ",");
        }
        
        String[] names = {"Kevin", "Daniel", "Katy", "Ana", "Joe", "Adam"};
        
        System.out.print("\nASC order: ");
        Arrays.sort(names);
        for (String name : names) {
            System.out.print(name + ",");
        }
        
        System.out.print("\nDESC order: ");
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.print(names[i] + ",");
        }
    }
}
