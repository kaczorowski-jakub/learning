package com.os.udemy.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * It preserves the order we insert elements unlikely the hash map
 * 
 * @author jakub.kaczorowski
 *
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 1);
        map.put("bbb", 2);
        map.put("ccc", 3);
        map.put("ddd", 4);
        map.put("eee", 5);
        map.put("fff", 6);
        map.put("ggg", 7);
        map.put("hhh", 8);
        map.put("iii", 9);
        map.put("jjj", 10);
        map.put("kkk", 11);
        
        // unordered
        for (String k : map.keySet()) {
            System.out.println(k + " - > " + map.get(k));
        }
        
        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("aaa", 1);
        map2.put("bbb", 2);
        map2.put("ccc", 3);
        map2.put("ddd", 4);
        map2.put("eee", 5);
        map2.put("fff", 6);
        map2.put("ggg", 7);
        map2.put("hhh", 8);
        map2.put("iii", 9);
        map2.put("jjj", 10);
        map2.put("kkk", 11);
        
        // ordered
        for (String k : map2.keySet()) {
            System.out.println(k + " - > " + map2.get(k));
        }

    }
}
