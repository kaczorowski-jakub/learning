package classinitializationorder;

public class ClassStaticSubClassExceptionTest {
    
    public static void main(String[] args) {
        SubClass cset = new SubClass();
        System.out.println(cset);
    }
}

class SubClass {
    static {
        int[] a = new int[10];
        a[10] = 15;
    }
}
