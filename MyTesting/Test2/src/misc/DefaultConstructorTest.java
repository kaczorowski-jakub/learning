package misc;

public class DefaultConstructorTest {
    
    public DefaultConstructorTest(int a) {
        // TODO Auto-generated constructor stub
    }
    public static void main(String[] args) {
        //DefaultConstructorTest dct = new DefaultConstructorTest(); //exception
        DefaultConstructorTest dct = new DefaultConstructorTest(10);
        System.out.println(dct);
    }
}
