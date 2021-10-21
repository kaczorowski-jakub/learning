package misc;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyThrd implements Runnable{
    
    public static void main(String[] args) {
        UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                
                System.out.println("Cought: " + e);
            }
        };
        Thread t = new Thread(new MyThrd());
        t.setUncaughtExceptionHandler(handler);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        try {
            Thread.sleep(1000);
            System.out.println(t.getState());
        } catch (Exception e) {
            
        }
        
        try {
            Thread.sleep(3000);
            System.out.println(t.getState());
        } catch (Exception e) {
            
        }
        System.out.println("ALA MA KOTA");
    }
    
    
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
//            while (true) {
//                
//            }
        } catch (Exception e) {
            
        }
        
        throw new RuntimeException("TEST");
        
    }
}
