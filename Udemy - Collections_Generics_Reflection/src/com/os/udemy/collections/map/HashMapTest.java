package com.os.udemy.collections.map;

import java.util.HashMap;

/**
 * it is based on an array [] of Node<K,V>
 * 
 * the index is being calculated by hashCode() of (K)ey and mod by the size of the array
 * 
 * if the same key objects return the same hash code and point to the same bucket we have
 * a collision, the last node under bucket will have its next node
 * 0 - null     null
 * 1 - null     null
 * 2 - K1       K1->K2  (collision result)
 * 3 - null     null
 * 
 * Default capacity is set to 16
 * Default threshold is set to 12 -> 16 * 0.75 (load factor)
 * 
 * Collision - when two different items are on the same bucket -> hash map will use
 * equals to see if the element is the same if not it will place the new key-value under
 * next node in the same bucket. If it is the same it will REPLACE it in the collection
 * 
 * the very good practice is to implement hashCode and equals as follows:
 * - if the elements are equal they have to have the same hash code
 * - the same hash code of two elements does not mean they are equal, eg.
 *   String: 'AA' (65 + 65 = 130) and String '<F' (60 + 70 = 130) 
 * 
 * @author jakub.kaczorowski
 *
 */
public class HashMapTest {
    public static void main(String[] args) {
        myTestHashCode();
        myTestCollision();
        myTestAddingTheSame();
    }
    
    private static void myTestHashCode() {
        System.out.println("A".hashCode());
        System.out.println("AA".hashCode());
    }
    
    private static void myTestCollision() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("Ala", "1");
        map.put("Ania", "2");
        map.put("Koc", "3");
        map.put("Test1", "4");
        map.put("Basia", "5");
        map.put("Tosia", "6");  // Tosia will have the same Bucket as Basia
        map.put("Zosia", "7");
        map.put("Abc", "8");    // same Bucket as Basia and Tosia
        map.put("Def", "9");
        System.out.println(map);
    }
    
    private static void myTestAddingTheSame() {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.put("A", "12")); // null
        System.out.println(map.put("B", "13")); // null
        System.out.println(map.put("A", "19")); // 12 - old value under A
        System.out.println(map);
    }
    
    
}