package misc;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("A"));
        System.out.println(set.add("A"));
        System.out.println(set.add(null));
        
    }
}
