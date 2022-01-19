package overriding;

public class PrivateMethodSub extends PrivateMethod{
    
    private void met1() {
        System.out.println("PrivateMethodSub");
    }
    
    @Override
    public void met2() {
        System.out.println("PrivateMethodSub2");
    }
    
    public void caller2() {
        met1();
        met2();
    }
    
    public static void main(String[] args) {
        PrivateMethod pm1 = new PrivateMethod();
        pm1.caller();
        
        PrivateMethod pm2 = new PrivateMethodSub();
        pm2.caller();
        
        PrivateMethodSub pm3 = new PrivateMethodSub();
        pm3.caller2();
    }
}
