package misc;

public class Test14 {

    private final int v1;
    private final boolean v2;

    public Test14(int v1, boolean v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public static void main(String[] args) {

        Test14 t1 = new Test14(1, false);
        Test14 t2 = new Test14(2, true);
        Test14 t3 = new Test14(1, false);
        
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
    }
    
    public int getV1() {
        return v1;
    }
    
    public boolean isV2() {
        return v2;
    }
    
    private void test() {
        
    }
    
    private void test(int a) {
        
    }

}
