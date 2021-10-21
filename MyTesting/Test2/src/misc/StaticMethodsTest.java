package misc;

public class StaticMethodsTest {

}

class Super {
    void foo() {
        System.out.println("Super");
    }
}

class Subclass extends Super {
    static void foo() {
        System.out.println("Subclass");
    }
}

class Super2 {
    static void foo() {
        System.out.println("Super");
    }
}

class Subclass2 extends Super2 {
    void foo() {
        System.out.println("Subclass");
    }
}