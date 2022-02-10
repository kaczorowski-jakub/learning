package tests;

public class Test01 {

    public void test() {
        for (int a = 10, b = 100; a < b; a++) {
            System.out.println(a + ", " + b);
            a+=10;
            b++;
        }
    }
    
    public void test2() {
        {
            int a = 12;
            System.out.println(a);
        }
        int a = 13;
        
        System.out.println(a);
    }
}
