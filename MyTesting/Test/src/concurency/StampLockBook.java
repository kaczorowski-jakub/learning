package concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampLockBook {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		StampedLock lock = new StampedLock();

		executor.submit(() -> {
			long stamp = lock.tryOptimisticRead();
			try {
				System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
				sleep(1);
				System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
				sleep(2);
				System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
			} finally {
				try {
					lock.unlock(stamp);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

		executor.submit(() -> {
			long stamp = lock.writeLock();
			try {
				System.out.println("Write Lock acquired");
				sleep(2);
			} finally {
				lock.unlock(stamp);
				System.out.println("Write done");
			}
		});

	}

	public static void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {

		}
	}
}
