package com.os.udemy.collections.tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * BST - binart tree search
 *              12
 *            4    20
 *          3   6     98
 *          
 * 
 * RB trees - red-black trees - balanced trees
 *  
 *  they are sorted and balanced
 * 
 * @author jakub.kaczorowski
 *
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(10,"ten");
        map.put(3,"three");
        map.put(5,"five");
        map.put(1,"one");
        map.put(8,"eight");
        
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        TreeMap<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
        map2.putAll(map);
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // reversed order
        System.out.println("Smallest " + map2.lastKey());   
        System.out.println("Largest " + map2.firstKey());
    }
}
