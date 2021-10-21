package misc;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Integer> tree = new TreeMap<>();
        tree.put("A", 12);
        //tree.put(null, 0);// null pointer here
        tree.put("B", null);
        System.out.println(tree);
    }
}
