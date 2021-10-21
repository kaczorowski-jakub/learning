package misc;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test19 {
    public static void main(String[] args) {
        
        Set<String> ss = new HashSet<>();
        ss.add(null);
        System.out.println(ss);
        
        HashSet<Animal> hs = new HashSet<>();
        hs.add(new Animal());
        hs.add(new Animal());
        for (Animal a : hs) {
            System.out.println(a);
        }
        try {
            throw e();
        } catch (Exception e) {
            System.out.println(e);
        }
        Thread t = new Thread();
        Runnable r = new Runnable() {
        @Override
            public void run() {
                // TODO Auto-generated method stub
                
            }    
        };
        Object o = new Object();
        
        test2();
        
        Set<String> s = new HashSet<>();
        s.add("TEST");
        Set<String> set = Collections.unmodifiableSet(s);
        set.add("T2");
    }
     public static void main(String[] args, int a) {
         
     }
    public static Exception e() {
        return new Exception();
    }
    
    public static void test2() {
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        System.out.println(set.add(null));
    }
    
    public static void test() {
        try {
            int x = 0;
            int y = 5/x;
        } catch(Exception e) {
            
        }
        /*
         * catch(ArithmeticException e) {
         * 
         * }
         */
    }
}

class Animal {
    public int i = 12;
    
    Animal() {
        i = 13;
    }
    
    @Override
    public String toString() {
        return "Animal" + i;
    }
}
