package com.os.udemy.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.os.udemy.collections.CollectionSpy;

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
 * best case scenario of getting element is O(1)
 * worst case scenario of getting element is O(n) - hashcode is the same for all
 * the element 
 * 
 * @author jakub.kaczorowski
 *
 */
public class HashMapTest {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        basic();
        personObjTest();
        loadFactor();
        myTestHashCode();
        myTestCollision();
        myTestAddingTheSame();
    }
    
    private static void personObjTest() throws IllegalArgumentException, IllegalAccessException {
        Map<Person, String> map = new HashMap<>();
        
        map.put(new Person("Jan", 23), "YES");
        map.put(new Person("Jan", 23), "NO");   // replacing the object will be equal due to equals method
        System.out.println(map);
        map.clear();
        map.put(new Person("A", 16), "NO");
        map.put(new Person("B", 16), "NO");
        map.put(new Person("C", 16), "NO");
        map.put(new Person("D", 16), "NO");
        map.put(new Person("E", 16), "NO");
        map.put(new Person("F", 16), "NO");
        map.put(new Person("G", 16), "NO");
        map.put(new Person("H", 16), "NO");
        map.put(new Person("I", 16), "NO");
        map.put(new Person("J", 16), "NO");
        map.put(new Person("K", 16), "NO");
        CollectionSpy.printMap(map);
        System.out.println(map);
    }
    
    private static void basic() {
        Map<Integer, String> map = new HashMap<>();
        
        map.put(1, "ALA");
        map.put(20, "KOT");
        System.out.println(map);
        map.put(20, "PIES");
        System.out.println(map);
        map.put(null, "NULL VALUE");
        System.out.println(map);
        
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("KEY " + entry.getKey() +" , value " + entry.getValue());
        }
    }
    
    private static void loadFactor() throws IllegalArgumentException, IllegalAccessException {
        Map<String, Integer> map = new HashMap<>();
        
        System.out.println("Empty");
        CollectionSpy.printMap(map);
        
        map.put("T1", 1);
        map.put("T2", 2);
        map.put("T3", 3);
        map.put("T4", 4);
        map.put("T5", 5);
        map.put("T6", 6);
        map.put("T7", 7);
        map.put("T8", 7);
        map.put("T9", 7);
        map.put("T10", 7);
        map.put("T11", 7);
        map.put("T12", 7);
        System.out.println("Reaching max");
        CollectionSpy.printMap(map);
        map.put("T13", 7);
        System.out.println("After resizing");
        CollectionSpy.printMap(map);

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