package concurency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLockReadWrite {

	ReadWriteLock lock = new ReentrantReadWriteLock();
	int i = 0;
	
	public static void main(String[] args) {

		MyLockReadWrite ml = new MyLockReadWrite();

		Runnable r1 = () -> {
			System.out.println("R1");
			try {
				ml.lock.writeLock().lock();
				ml.i = 12;
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			} finally {
				ml.lock.writeLock().unlock();
				System.out.println("R1-END");
			}
		};
		
		Runnable r2 = () -> {
			System.out.println("R2");
			try {
				ml.lock.readLock().lock();
				System.out.println(ml.i);
			} finally {
				ml.lock.readLock().unlock();
				System.out.println("R2-END");
			}
		};
		

		Runnable r3 = () -> {
			System.out.println("R3");
			try {
				ml.lock.readLock().lock();
				System.out.println(ml.i);
			} finally {
				ml.lock.readLock().unlock();
				System.out.println("R3-END");
			}
		};
		
		new Thread(r1).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
		new Thread(r2).start();
		new Thread(r3).start();
		
		// najpierw czytamy pozniej piszemy
		
		Runnable r4 = () -> {
			System.out.println("R4");
			try {
				ml.lock.readLock().lock();
				System.out.println("READ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			} finally {
				ml.lock.readLock().unlock();
				System.out.println("R4-END");
			}
		};
		
		new Thread(r4).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
		new Thread(r1).start();
		
	}

}
