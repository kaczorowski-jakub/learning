package misc;

public class ThreadChecking extends Thread{
    @Override
    public void run() {
        ThreadSynch.test(this.getName());
    }
}
