package misc;

public enum EnumTest {
    
    A(1,"A"){
        @Override
        void show() {
            System.out.println("Show in A");
            
        }
    },B(1) {
        @Override
        void show() {
            System.out.println("Show in B");
            
        }
    };
    
    public static void main(String[] args) {
        EnumTest.A.show();;
        EnumTest.B.show();;
    }
    
    EnumTest(int a, String b) {
        
    }
    
    EnumTest(int a) {
        
    }
    
    public void test() {
        
    }
    
    private void test2() {
        
    }
    
    abstract void show();
}
