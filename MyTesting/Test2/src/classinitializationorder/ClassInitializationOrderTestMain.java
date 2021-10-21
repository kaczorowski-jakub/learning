package classinitializationorder;

public class ClassInitializationOrderTestMain {
    public static void main(String[] args) {
        ClassInitializationOrderTest ciot;
        System.out.println("---");
        CIOT1 ciot1 = ClassInitializationOrderTest.ciot1;
        System.out.println("---");
        ciot = new ClassInitializationOrderTest();
        System.out.println("END");
    }
}