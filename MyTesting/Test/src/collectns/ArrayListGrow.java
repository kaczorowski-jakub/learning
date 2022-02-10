package collectns;

import java.util.ArrayList;

public class ArrayListGrow {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        addElement(arr, "1");
        addElement(arr, "2");
        addElement(arr, "3");
        addElement(arr, "4");
        addElement(arr, "5");
        addElement(arr, "6");
        addElement(arr, "7");
        addElement(arr, "8");
        addElement(arr, "9");
        addElement(arr, "10");
        addElement(arr, "11");
        addElement(arr, "12");
        
    }
    
    private static void addElement(ArrayList<String> arr, String val) {
        long start = System.currentTimeMillis();
        arr.add(val);
        long stop = System.currentTimeMillis();
        System.out.println("Size after: " + arr.size() + ", duration: " + (stop - start));
    }
}
