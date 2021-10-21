package misc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        Set<String> setUn = Collections.unmodifiableSet(set);
        
        try {
            setUn.add("C");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(setUn);
        }
        
        set.add("C");
        System.out.println(setUn);
        
        // using Set.of
        Set<String> setUn2 = Set.of("A","B","C");
        System.out.println(setUn2);
        try {
            setUn2.add("D");
        } catch (Exception e) {
            System.out.println(e);
        }

        // using Set.copyOf
        Set<String> setUn3 = Set.copyOf(set);
        System.out.println(setUn3);
        set.add("D");
        System.out.println(setUn3);
        try {
            setUn3.add("E");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
