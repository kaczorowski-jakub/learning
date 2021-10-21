package concurency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {

	public static void main(String[] args) {

		Semaphore s = new Semaphore(5);

		Runnable r1 = () -> {
			boolean b = false;

			try {

				b = s.tryAcquire(1, TimeUnit.MILLISECONDS);
				if (b) {
					System.out.println("SEM1 - OK");
					Thread.sleep(2000);
				}
				else
					System.out.println("SEM1 -NOT OK");
			} catch (InterruptedException e) {

			} finally {
				if (b)
					s.release();
			}

		};

		Runnable r2 = () -> {
			boolean b = false;

			try {
				s.acquire();
				System.out.println("SEM2 - OK");
				Thread.sleep(2000);

			} catch (InterruptedException e) {

			} finally {
				s.release();
			}

		};

		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();
		new Thread(r1).start();

		new Thread(r2).start();
		new Thread(r2).start();
		new Thread(r2).start();
		new Thread(r2).start();
		new Thread(r2).start();
		new Thread(r2).start();

	}

}
