package exception;

import static java.lang.System.out;

import java.io.Closeable;

public class Test {

	Exception e;

	public static void main(String[] args) {

		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		test6();

	}
	public static void test6() {

		try {
			test6bis();
		} catch (Exception e) {
			out.println(e.getSuppressed().length);
		}
	}

	public static void test6bis() {

		try (BBB b = new BBB()) {

		} finally {
			int[] a = new int[4];
			a[10] = 12;
		}

	}

	static class BBB implements Closeable {

		@Override
		public void close() {

			Class c = null;
			c.getName();
		}

	}

	public static void test5() {

		try {
			test5bis();
		} catch (Exception e) {
			out.println(e.getSuppressed().length);
		}
	}

	public static void test5bis() {

		Class c = null;

		try {
			int[] b = new int[5];
			b[10] = 44;
		} finally {
			c.getName();
		}

	}

	public static void test4() {

		try (Cls c = new Cls(); Cls c1 = new Cls()) {

		}

		try (Cls c = new Cls(); Cls c1 = new Cls()) {
			throw new Exception();
		} catch (Exception e) {
			out.println("CATCH");
		} finally {
			out.println("FINALLY");
		}

	}

	public static void test3() {

		try {
			int[] a = new int[5];
			a[10] = 55;

		} finally {
			out.println("FINALLY IN TEST3");
		}

	}

	public static void test2() {

		out.println("BEFORE TRY");

		try {
			out.println("IN TRY");
			return;

		} catch (NullPointerException e) {
			out.println("IN CATCH");
		} finally {
			out.println("IN FINALLY");
		}

		out.println("AFTER TRY");

		return;

	}

	public static void test1() {
		Test a = new Test(new NullPointerException());
		Test b = new Test(new IndexOutOfBoundsException());
		Test c = new Test(new ArithmeticException());
	}

	public Test(Exception e) throws NullPointerException {
		this.e = e;

		out.println("constructor");

		try {
			m1();
		} catch (Exception ex) {
			out.println("catch in constructor - Exception");
		}
	}

	public void m1() throws Exception {

		out.println("function m1");

		try {
			m2();
		} catch (ArithmeticException | ClassCastException e) {
			out.println("catch in m1 - ArithmeticException or ClassCastException");
		}

	}

	public void m2() throws Exception {

		out.println("function m2");

		m3();
	}

	public void m3() throws Exception {

		out.println("function m3");

		try {
			m4();
		} catch (NullPointerException e) {
			out.println("catch in m3 - NullPointerException");
		}

	}

	public void m4() throws Exception {

		out.println("function m4");

		m5();
	}

	public void m5() throws Exception {

		out.println("function m5");

		throw e;
	}

}
