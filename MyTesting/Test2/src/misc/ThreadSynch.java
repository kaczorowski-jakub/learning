package misc;

public class ThreadSynch {
    
    public static void test(String val) {
        
        System.out.println("In: " + val);
        
        synchronized(ThreadSynch.class) {
            try {
                System.out.println("synch: " + val);
                Thread.sleep(8000);
            } catch (Exception e) {
                
            }
        }
        
    }
    
}
