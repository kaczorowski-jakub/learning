package misc;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        int index = 1;
        Boolean [] test = new Boolean[3];
        Boolean data = test[index];
        System.out.println(data);
        
        int a[ ][ ] = new int [4] [4];
        double d = 100.04;  
        //float f = d;
        int ab[] = new int[0];
        
        //
        int Output = 10;
        boolean b1 = false;
        if((b1 == true) && ((Output += 10) == 20))
        {
            System.out.println("We are equal " + Output);
        }
        else
        {
            System.out.println("Not equal! " + Output);
        }
        System.out.println(Output);
        
        //
        byte x = 64;
        int i;
        byte y; 
        i = x << 2;
        y = (byte) (x << 2);
        System.out.println(i + " " + y);
        
        //
        int var1 = 5; 
        int var2 = 6;
        if ((var2 = 1) == var1)
            System.out.println(var2);
        else 
            System.out.println(++var2);
        
        //test(new ArrayList<String>());
        
        int x1, y1 = 1;
        x1 = 10;
        if (x1 != 10 && x1 / 0 == 0)
            System.out.println(y1);
        else
            System.out.println(++y1);
        
    }
    
    public void test(List<Object> list) {
        
    }
    
    
    
}
