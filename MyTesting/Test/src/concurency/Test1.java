package concurency;

import static java.lang.System.out;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {

		// test1();
		// test2();
		// test3();
		test4();
	}

	private static void test4() {

		Thread t1 = new Thread(() -> {

			try {
				out.println("T1");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				out.println("STOP");
			}

		});
		Thread t2 = new Thread(() -> {

			try {
				out.println("T2");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				out.println("STOP");
			}

		});
		Thread t3 = new Thread(() -> {

			try {
				out.println("T3");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				out.println("STOP");
			}

		});

		t1.start();

		try {
			t1.join(5000);
		} catch (InterruptedException e) {

		}

		t2.start();

		try {
			t2.join(5000);
		} catch (InterruptedException e) {

		}
		
		t3.start();

		try {
			t3.join(5000);
		} catch (InterruptedException e) {

		}

	}

	private static void test1() {
		MyThread mt = (new Test1()).new MyThread();
		mt.start();

		char c = 'A';
		do {

			try {
				c = (char) System.in.read();
			} catch (IOException io) {

			}

		} while (c != 'Q');

		mt.interrupt();
	}

	private static void test2() {

		Thread t = new Thread(() -> {

			for (int i = 0;;) {

				try {
					Thread.sleep(3000);
					out.println(i--);
				} catch (InterruptedException e) {
					out.println("STOP");
					break;
				}

			}

		});
		t.start();

		char c = 'A';
		do {

			try {
				c = (char) System.in.read();
			} catch (IOException io) {

			}

		} while (c != 'Q');

		t.interrupt();

	}

	private static void test3() {

		Thread t = new Thread(() -> {

			for (int i = 0;;) {

				out.println(i += 2);
				if (Thread.interrupted()) {
					return;
				}

			}

		});
		t.start();

		char c = 'A';
		do {

			try {
				c = (char) System.in.read();
			} catch (IOException io) {

			}

		} while (c != 'Q');

		t.interrupt();

	}

	private class MyThread extends Thread {

		@Override
		public void run() {

			for (int i = 0;;) {

				try {
					sleep(2000);
					out.println(i++);
				} catch (InterruptedException e) {
					out.println("STOP");
					break;
				}

			}

		}

	}
}