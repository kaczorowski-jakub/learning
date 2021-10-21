package classinitializationorder;

public class ClassInitializationOrderTest {
    
    public static final CIOT1 ciot1 = new CIOT1();
    public static CIOT2 ciot2 = new CIOT2();
    public CIOT3 ciot3 = new CIOT3();
    
    static {
        System.out.println("ClassInitializationOrderTest static init section");
    }
    {
        System.out.println("ClassInitializationOrderTest non-static init section");
    }
    
}

class CIOT1 {
    
    CIOT1() {
        System.out.println("CIOT1 constructor");
    }
}

class CIOT2 {
    
    CIOT2() {
        System.out.println("CIOT2 constructor");
    }
}

class CIOT3 {
    
    CIOT3() {
        System.out.println("CIOT3 constructor");
    }
}