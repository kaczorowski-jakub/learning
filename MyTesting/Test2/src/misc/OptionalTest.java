package misc;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        OTD odt1 = null;
        Optional<OTD> opt = Optional.ofNullable(odt1);
        System.out.println(opt.isPresent());
        odt1 = new OTD();
        odt1.setVal("A");
        System.out.println(opt.isPresent());
        int[] a = {1,2,3};
        Integer[] b = {4,5,6};
        test(new String[]{"A","B"});
        test(b);
        
        for (int i = 1;;) {
            
        }
    }
    
    private static void test(String[] a) {
        
    }
    
    private static void test(Object[] a) {
        
    }
    
    private static class OTD {
        String val;
        
        public void setVal(String val) {
            this.val = val;
        }
        
        public String getVal() {
            return val;
        }
    }
}
