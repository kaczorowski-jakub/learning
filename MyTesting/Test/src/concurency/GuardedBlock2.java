package concurency;

public class GuardedBlock2 {

	String action = "";

	public static void main(String[] args) {

		GuardedBlock2 gb = new GuardedBlock2();

		Thread t1 = new Thread(() -> {

			synchronized (gb) {

				while (!gb.action.equals("PRZYSIAD")) {
					try {
						gb.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("PRZYSIAD sie wykonal");
			}

		});

		Thread t2 = new Thread(() -> {

			synchronized (gb) {

				while (!gb.action.equals("WYSKOK")) {
					try {
						gb.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("WYSKOK sie wykonal");
			}

		});

		t1.start();
		t2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}

		synchronized (gb) {
			gb.action = "PRZYSIAD";
			gb.notifyAll();
		}

		/*
		 * jezeli usuniemy czekanie to watek nie zdazy zareagowac i nie wykona
		 * sie watek, ktory czeka na PRZYSIAD
		 */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}

		synchronized (gb) {
			gb.action = "WYSKOK";
			gb.notifyAll();
		}

	}

}
