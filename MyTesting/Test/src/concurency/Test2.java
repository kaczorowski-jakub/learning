package concurency;

public class Test2 {

	TBLock tbl = new TBLock();

	int cnt = 0;

	void inc() {
		cnt++;
	}

	void dec() {
		cnt--;
	}

	void print() {
		System.out.println(cnt);
	}

	synchronized void incS() {
		cnt++;
		System.out.println("incS");
	}

	synchronized void decS() {
		cnt--;
		System.out.println("decS");
	}

	synchronized void printS() {
		System.out.println("PrintS: " + cnt);
	}

	synchronized void slp() {
		while (cnt == 0) {
			//System.out.println(cnt); //kopia zmiennej w watku?
		}
	}

	void m1(int val, boolean plus) {

		synchronized (tbl) {

			if (plus)
				tbl.val += val;
			else
				tbl.val -= val;

		}

		System.out.println(tbl.val);

	}

	public static void main(String[] args) {
		
		// test1();
		// test2();
		test3();
		//test4();
	}

	public static void test4() {

		Test2 test2 = new Test2();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				test2.m1(i, true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				test2.m1(i, false);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
			System.out.println("FINAL: " + test2.tbl.val);
		} catch (InterruptedException e) {

		}
	}

	public static void test3() {

		Test2 test2 = new Test2();

		Thread t1 = new Thread(() -> {
			test2.slp();
		});
		Thread t2 = new Thread(() -> {
			test2.decS();
		});
		Thread t3 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			test2.printS();
		});

		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(500);
			test2.inc();
		} catch (InterruptedException e) {
			
		}
	}

	public static void test2() {
		Test2 test2 = new Test2();
		Thread t1 = new Thread(() -> {

			try {
				for (;;) {
					Thread.sleep(1000);
					test2.incS();
				}
			} catch (InterruptedException e) {

			}
		});

		Thread t2 = new Thread(() -> {
			try {
				for (;;) {
					Thread.sleep(1000);
					test2.decS();
				}
			} catch (InterruptedException e) {

			}
		});

		Thread t3 = new Thread(() -> {
			try {
				for (;;) {
					Thread.sleep(100);
					test2.printS();
				}
			} catch (InterruptedException e) {

			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

	public static void test1() {
		Test2 test2 = new Test2();
		Thread t1 = new Thread(() -> {

			try {
				for (;;) {
					Thread.sleep(1000);
					test2.inc();
				}
			} catch (InterruptedException e) {

			}
		});

		Thread t2 = new Thread(() -> {
			try {
				for (;;) {
					Thread.sleep(1000);
					test2.dec();
				}
			} catch (InterruptedException e) {

			}
		});

		Thread t3 = new Thread(() -> {
			try {
				for (;;) {
					Thread.sleep(100);
					test2.print();
				}
			} catch (InterruptedException e) {

			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

	private class TBLock {

		int val;

	}

}
