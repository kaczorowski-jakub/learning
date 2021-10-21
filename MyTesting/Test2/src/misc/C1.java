package misc;

public class C1 implements I1 {
    
    public void test() {
        System.out.println("test in C1");
    }
    
    public void test2() {
        I1.super.test2();
        System.out.println("test2 in C1");
    }
}
