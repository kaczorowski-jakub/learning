package concurency;

import static java.lang.System.out;

import java.util.concurrent.locks.ReentrantLock;

public class MyLockReentrant {

	ReentrantLock lock = new ReentrantLock();
	int i = 0;

	public void inc() {

		try {

			lock.lock();
			out.println("INC");
			Thread.sleep(3000);
			i++;

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print() {

		try {
			out.println(lock.isLocked());
			out.println(lock.isHeldByCurrentThread());
			lock.lock();
			out.println("DEC");

		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		MyLockReentrant mlr = new MyLockReentrant();

		Thread t1 = new Thread(() -> {

			mlr.inc();

		});

		Thread t2 = new Thread(() -> {
			mlr.print();
		});

		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		t2.start();
	}

}
