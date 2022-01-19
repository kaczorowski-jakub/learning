package overriding;

public class PrivateMethod {
    
    private void met1() {
        System.out.println("PrivateMethod");
    }
    
    public void met2() {
        System.out.println("PrivateMethod2");
    }
    
    public void caller() {
        met1();
        met2();
    }
}
