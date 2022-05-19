package exception;

public class FinallyTest {
    public static void main(String[] args) {
        
        System.out.println(manipulateVal());
        System.out.println(changeVal());
        
    }

    private static int manipulateVal() {
        int a = 0;
        try {
            a++;
            return a;
        } catch (Exception e) {
            a += 100;
        } finally {
            return a + 1000;
        }
    }
    
    private static int changeVal() {
        int a = 0;
        try {
            a++;
            return a;
        } catch (Exception e) {
            a += 100;
        } finally {
            return 500;
        }
    }
}
