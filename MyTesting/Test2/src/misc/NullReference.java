package misc;

public class NullReference {
    int a;
    
    public static void main(String[] args) {
        NullReference nr = null;
        nr.test();
        nr = new NullReference();
        int c;
        System.out.println(nr.a);
        testByte(1);
    }
    
    
    public static void test() {
        System.out.println("TEST");
    }
    public static void main(String a) {
        
    }
    
    public static void testByte(byte b) {
        
    }
}
