package concurrency;

public class SuspendedState {
    
    public static void main(String[] args) {
        TestClass ts = new TestClass();
        
        Thread t1 = new Thread(() -> {
            ts.doSum();
        });
        
        Thread t2 = new Thread(() -> {
            ts.doSum();
        });
        
        t1.start();
        t2.start();
        
    }
    
    private static class TestClass {
        
        private int sum = 0;
        
        public synchronized void doSum() {
            sum++;
            
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        public int getSum() {
            return sum;
        }
        
    }
    
    
}
