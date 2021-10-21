package concurrency;

public class MonitorTest {

    private int cnt = 0;

    public synchronized void inc() {
        cnt++;
        try {
            System.out.println("INC");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            
        }
    }

    public synchronized void dec() {
        cnt--;
        try {
            System.out.println("DEC");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            
        }
    }

    public int getCnt() {
        return cnt;
    }

    public static void main(String[] args) {
        MonitorTest mt = new MonitorTest();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                mt.inc();
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                mt.dec();
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(mt.getCnt());
            }
        }).start();
    }
}
