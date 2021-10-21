package misc;

public class OverridingTest {
    
    OverridingTest() {
        test();
        testRun();
    }
    private void test() {
        System.out.println("in SuperClass");
    }
    public void testRun() {
        System.out.println("in SuperClass");
    }
    public static void main(String[] args) {
        OverridingTest ot = new OverridingTestSub();
        
    }
}

class OverridingTestSub extends OverridingTest{

    private void test() {
        System.out.println("in SubClass");
    }
    public void testRun() {
        System.out.println("in SubClass");
    }
}
