package misc;

import java.util.HashSet;
import java.util.Set;

public interface Test15 {
    
    public default void test() {
        
    }
    
    public static void test2() {
        
    }
    
    public static void main(String[] args) {
        //test1(); //error
        test2();
        
        Set<A> set = new HashSet<>();
        A a1 = new A(1,"A");
        A a2 = new A(2,"B");
        A a3 = new A(3,"C");
        System.out.println(set.add(a3));
        System.out.println(set.add(a2));
        System.out.println(set.add(a1));
        System.out.println(set);
        
        System.out.println(set.add(a2));
        System.out.println(set.add(null));
    }
    
    public class A {
        private final int v;
        private final String c;
        
        public A(int v, String c) {
            this.v = v;
            this.c = c;
        }
        
        public String getC() {
            return c;
        }
        
        public int getV() {
            return v;
        }
        
        @Override
        public String toString() {
            return v + " - " + c;
        }
        
        @Override
        public boolean equals(Object obj) {
            
            // # 1
            return false;
        }
        
        @Override
        public int hashCode() {
            return 1;
        }
    }
    
}
