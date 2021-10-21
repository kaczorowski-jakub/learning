package misc;

import java.util.HashMap;
import java.util.Map;

public class Test18 {
    int a;
    public static void main(String[] args) {
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ALA");
        map.put(1,"BEATA");
        System.out.println(map);
        Test18.A b = (new Test18()).new A();
        Test18.B a = new Test18.B();
    }
    
   class A {
       //private static int a = 12;
       private int a = 1;
       
       void test() {
           Test18.this.a = 14;
       }
       
   }
   
   static class B {
       private int a = 1;
       private static int b = 2;
      
   }
}
