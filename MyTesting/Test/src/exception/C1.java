package exception;

public class C1 extends C0 implements I1 {
	
	public C1() throws Error {
		super();
	}
	
	public void m1() throws RuntimeException {

	}

	@Override
	//public void m2() throws Exception { // nie zadziala bo Exception jest checked, a NullPointer jest Unchecked
	public void m2() throws Error {

		throw new NullPointerException();

	}

	public static void main(String[] args) {

		C0 c0 = new C1();
		c0.m2();

	}

	/*
	 * public void m1() throws ArrayIndexOutOfBoundsException {
	 * 
	 * }
	 */

}
