package concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MyExecutor {

	public static void main(String[] args) {

		// test0();
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
	}
	
	public static void test8() {

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
		Runnable r = () -> {
			
			long l = System.nanoTime();
			System.out.println("SCH-R " + l + " - START");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
			System.out.println("SCH-R " + l + " - STOP");
		};
		
		ses.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);
		//ses.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);
		//ses.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);

	}
	
	public static void test7() {

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
		Runnable r = () -> {
			
			long l = System.nanoTime();
			System.out.println("SCH-R " + l + " - START");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
			System.out.println("SCH-R " + l + " - STOP");
		};
		
		ses.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);

	}

	public static void test6() {

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

		Runnable r = () -> {

			System.out.println("SCH-R " + System.nanoTime());

		};

		ScheduledFuture<?> future = ses.schedule(r, 2, TimeUnit.SECONDS);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}

		System.out.println(future.getDelay(TimeUnit.MILLISECONDS));
		ses.shutdown();

	}

	public static void test5() {

		Callable<Integer> task = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			return 123;
		};

		Callable<String> task2 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "ALA MA KOTA";
			}

		};

		ExecutorService e = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = e.submit(task);
		Future<String> f2 = e.submit(task2);
		
		System.out.println(f1.isDone());
		try {
			int val = f1.get();
			System.out.println(f1.isDone());
			System.out.println(val);
			String a = f2.get();
			System.out.println(a);
		} catch (Exception ex) {

		}
		e.shutdown();
	}

	public static void test4() {

		ExecutorService e = Executors.newSingleThreadExecutor();

		e.submit(() -> {
			System.out.println("ESERV");
		});

		e.shutdown();
	}

	public static void test3() {

		Runnable r = () -> {

			try {
				System.out.println("YES");
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			} finally {
			}
		};

		Executor e = Executors.newFixedThreadPool(2);

		e.execute(r);
		e.execute(r);
		e.execute(r);
		e.execute(r);

		System.out.println("DUAP");
	}

	public static void test2() {
		Semaphore s = new Semaphore(3);

		Runnable r = () -> {

			try {
				s.acquire();
				System.out.println("YES");
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			} finally {
				s.release();
			}
		};

		Executor e = Executors.newSingleThreadExecutor();

		e.execute(r);
		e.execute(r);
		e.execute(r);
		e.execute(r);

		System.out.println("DUAP");
	}

	public static void test1() {
		Semaphore s = new Semaphore(3);

		Runnable r = () -> {

			try {
				s.acquire();
				System.out.println("YES");
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			} finally {
				s.release();
			}
		};

		Executor e = Executors.newFixedThreadPool(4);

		e.execute(r);
		e.execute(r);
		e.execute(r);
		e.execute(r);
	}

	public static void test0() {

		Executor e = Executors.newSingleThreadExecutor();

		e.execute(() -> {

			try {
				System.out.println("YES");
				Thread.sleep(3000);
				System.out.println("NO");
			} catch (InterruptedException ex) {

			}

		});

	}

}
