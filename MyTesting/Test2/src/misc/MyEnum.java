package misc;

public enum MyEnum {
    
    V1(1,"A"),V2(2,"B");
    
    private int a;
    private String b;
    
    private MyEnum(int a, String b) {
        this.a = a;
        this.b = b;
    }
    
}
