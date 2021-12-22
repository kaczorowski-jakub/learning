package generic;

import java.util.ArrayList;
import java.util.List;

public class ErasureCastErrorExample {
    public static void main(String[] args) {
        
        List list1 = new ArrayList<>();
        list1.add("1");
        list1.add("23");
        
        List<Integer> list2 = list1;
        int a = list2.get(0);
        System.out.println(a);
        
    }
}
