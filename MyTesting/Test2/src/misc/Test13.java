package misc;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Test13 {
    
    public static void main(String[] args) {
        //test1();
        test2();
        
    }
    
    private static void test1() {
        HashMap<String, Integer> wordCount = new HashMap<>();
        wordCount.put("Geeks", 1);
        wordCount.put("for", 2);
        wordCount.put("geeks", 3);
  
        // print HashMap details
        System.out.println("Hashmap before operation :\n "
                           + wordCount);
  
        // provide new value for keys which is present
        // using computeIfPresent method
        wordCount.computeIfPresent("Geek",
                                   (key, val) -> val + 100);
        
        // print new mapping
        System.out.println("HashMap after operation :\n "
                           + wordCount);
        
        wordCount.put("Geek", 4);
        System.out.println("HashMap after operation :\n "
                + wordCount);
        wordCount.computeIfPresent("Geek",
                (key, val) -> val + 100);
        System.out.println("HashMap after operation :\n "
                + wordCount);
    }
    
    private static void test2() {
        HashMap<String, Integer> wordCount = new HashMap<>();
        wordCount.computeIfPresent("T1", (String a, Integer b) -> {
            return b*2;
        });
        
        wordCount.put("T1", 100);
        
        System.out.println(wordCount);
    }
    
    private class BiFunctionImpl implements BiFunction<String, Integer, Integer> {
        
        @Override
        public Integer apply(String t, Integer u) {
            return u * 2;
        }
    }
    
}
