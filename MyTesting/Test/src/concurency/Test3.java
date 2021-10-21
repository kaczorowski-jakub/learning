package concurency;

public class Test3 {
	
	volatile int a = 0;
	int b = 0;
	
	private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            a++;
        }
    }

    public void inc2() {
        synchronized(lock2) {
            b++;
        }
    }
	
	
	
	public static void main(String[] args) {
		
		Test3 test3 = new Test3();
		
		
		
	}
	
}
