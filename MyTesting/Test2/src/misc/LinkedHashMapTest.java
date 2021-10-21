package misc;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("B", 2);
        map.put("A", 1);
        map.put("C", 3);
        map.keySet().forEach(k -> System.out.println(k + " -> " + map.get(k)));
        
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<String, Integer>(16, 0.75f, true);
        map2.put("B", 2);
        map2.put("A", 1);
        map2.put("C", 3);
        map2.get("B");
        map2.keySet().forEach(k -> System.out.println(k + " -> " + map.get(k)));
        System.out.println(map2.values());
    }
}
