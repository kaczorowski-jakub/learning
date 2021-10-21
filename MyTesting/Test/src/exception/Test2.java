package exception;

public class Test2 {

	public static void main(String[] args) {
		
		//test1();
		test2();
		
	}
	
	public static void test2() {
		
		try {
			test2bis();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
		}
		
	}
	
	public static void test2bis() {
		
		try {
			throw new Exception("ALA MA KOTA");
		} catch (Exception e) {
			throw new Error("DUPALA", e);
			
		}
	}
	
	public static void test1() {
		
		try {
			test1bis();
		} catch(Exception e) {
			
			System.out.println(e.getSuppressed()[0].getMessage());
			
		}
		
	}
	
	public static void test1bis() throws Exception {
		
		try {
			m1(-1);
		} catch (CustomExc e) {
			System.out.println("IN catch of test1bis");
			Exception ne = new Exception();
			ne.addSuppressed(e);
			throw ne;
		}
		
	}

	private static void m1(int i) throws CustomExc {

		if (i == -1)
			throw new CustomExc();
		else
			return;

	}

}
