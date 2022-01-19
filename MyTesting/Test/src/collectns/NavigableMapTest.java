package collectns;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {
    public static void main(String[] args) {
        NavigableMap<String, Integer> nm = new TreeMap<String, Integer>();

        // Add elements using put() method
        nm.put("C", 888);
        nm.put("Y", 999);
        nm.put("A", 444);
        nm.put("T", 555);
        nm.put("B", 666);
        nm.put("A", 555);
        
        System.out.println("Original tree: " + nm);
        System.out.println("Celing Entry of D: " + nm.ceilingKey("D"));
        System.out.println("Floor Entry of D: " + nm.floorKey("D"));
    }
}
