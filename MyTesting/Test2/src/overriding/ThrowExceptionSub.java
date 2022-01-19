package overriding;

import java.io.IOException;

public class ThrowExceptionSub extends ThrowException {
    
    /*
     * - Exception Exception is not compatible with throws clause in 
     ThrowException.met1()
    - overrides overriding.ThrowException.met1
     
    public void met1() throws Exception {

    }
    */
    
    // this is OK, because IOBE is a subclass of RuntimeException
    @Override
    public void met1() throws IndexOutOfBoundsException {

    }
    
    @Override
    public void met2() throws IOException {

    }
    
    public static void main(String[] args) {
        ThrowExceptionSub tes = new ThrowExceptionSub();
        
        try {
            tes.met2();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            tes.met2();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ThrowException te = new ThrowExceptionSub();
        
        try {
            te.met2();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*
         // Unhandled exception type Exception
        try {
            te.met2();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        
        
    }

}
