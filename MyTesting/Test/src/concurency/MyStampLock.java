package concurency;

import java.util.concurrent.locks.StampedLock;

public class MyStampLock {

	int cnt = 0;
	StampedLock sl = new StampedLock();

	public static void main(String[] args) {

		MyStampLock msl = new MyStampLock();

		Runnable r1 = () -> {
			System.out.println("R1");
			long l = msl.sl.writeLock();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			} finally {
				System.out.println("R1 - END");
				msl.sl.unlockWrite(l);
			}

		};

		Runnable r2 = () -> {
			System.out.println("R2");
			long l = msl.sl.readLock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			} finally {
				System.out.println("R2 - END");
				msl.sl.unlockRead(l);
			}

		};

		Runnable r3 = () -> {
			System.out.println("R3");
			long l = msl.sl.tryOptimisticRead();
			try {
				boolean b = true;
				do {
					b = msl.sl.validate(l);
					System.out.println("stamp: " + l + " is " + b);
					Thread.sleep(300);
				} while (b);
			} catch (InterruptedException e) {

			} finally {
				System.out.println("R3 - END");
				if (msl.sl.validate(l))
					msl.sl.unlockRead(l);
			}

		};
		new Thread(r3).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		new Thread(r1).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		new Thread(r2).start();
	}

}
