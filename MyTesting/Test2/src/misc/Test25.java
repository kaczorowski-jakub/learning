package misc;

public class Test25 {
    public static void main(String[] args) {
        
    }
    
    void waitForSignal() {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            obj.wait();
            obj.notify();
        }
    }
}
