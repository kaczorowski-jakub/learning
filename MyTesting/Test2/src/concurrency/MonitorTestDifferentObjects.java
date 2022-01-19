package concurrency;

/**
 * In this example we set locks on different objects so when thread1 and thread2 execute different
 * methods we check different objects
 * @author jakub.kaczorowski
 *
 */
public class MonitorTestDifferentObjects {

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void print1() {
        synchronized (lock1) {
            try {
                System.out.println("Print1 Method");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized void print2() {
        synchronized (lock2) {
            try {
                System.out.println("Print2 Method");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        MonitorTestDifferentObjects mt = new MonitorTestDifferentObjects();

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
    }
}
