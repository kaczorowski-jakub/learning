package misc;

class Test10 
{
    private int a = 12;
    
    public static void main(String [] args) 
    {
        Test10 p = new Test10();
        p.start();
    }

    void start() 
    {
        Test10 t = new Test10();
        t.a = 30;
        fix(t);
        System.out.println(t.a);
    }

    void fix(Test10 t) 
    {
        t = new Test10();
        
    }
}
