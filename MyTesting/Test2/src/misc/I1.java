package misc;

import java.io.Serializable;

public interface I1 {
    
    static void test() {
        System.out.println("test in I1");
    }
    
    default void test2() {
        System.out.println("test2 in I1");
    }
    
}
