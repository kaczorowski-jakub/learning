package misc;

public class Test12 {
    static int s;
    public static void main(String [] args) 
    {
        Test12
         p = new Test();
        p.start();
        System.out.println(s);
    }

    void start() 
    {
        int x = 7;
        twice(x);
        System.out.print(x + " ");
    }

    void twice(int x) 
    {
        x = x*2;
        s = x;
    }
}
