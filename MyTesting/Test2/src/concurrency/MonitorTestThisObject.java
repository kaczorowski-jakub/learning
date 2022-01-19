package concurrency;

/**
 * In this class please see that print1() and print2() are both synchronized
 * It means that once a thread gets to one of them no other thread can execute
 * none of them because the lock is done on this object
 * 
 * @author jakub.kaczorowski
 *
 */
public class MonitorTestThisObject {

    public synchronized void print1() {
        try {
            System.out.println("Print1 Method");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            
        }
    }

    public synchronized void print2() {
        try {
            System.out.println("Print2 Method");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            
        }
    }
    
    public void print3() {
        try {
            System.out.println("Print3 Method");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            
        }
    }

    public static void main(String[] args) {
        MonitorTestThisObject mt = new MonitorTestThisObject();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                mt.print1();
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                mt.print2();
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                mt.print3();
            }
        }).start();
    }
}
