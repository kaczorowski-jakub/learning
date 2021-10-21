package classinitializationorder;

public class ClassStaticExceptionTest {

    static {
        int[] a = new int[10];
        a[10] = 15;
    }

    public static void main(String[] args) {
        ClassStaticExceptionTest cset = new ClassStaticExceptionTest();
        System.out.println(cset);
    }
}
