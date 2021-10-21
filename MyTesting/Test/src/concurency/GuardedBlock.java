package concurency;

public class GuardedBlock {

	boolean t1 = false;
	
	public synchronized void print() {

		// blok 1 - czekamy na t1=true
		while (!t1) {
			System.out.println("PETLA");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// kod do wykonania
		System.out.println("ROBOTA ZROBIONA");
	}
	
	public static void main(String[] args) {

		GuardedBlock gb = new GuardedBlock();

		// watek 1
		Thread t1 = new Thread(() -> {
			gb.print();
		});
		t1.start();

		// poczekaj na wystartowanie t1
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		
		// synchronized po to, ze dla NotifyAll trzeba posiadac lock
		synchronized (gb) {
			//gb.t1 = true;
			gb.notifyAll();
		}
		
		//t1.run();
	}
}
