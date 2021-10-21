package privatemethodInheritance;

public class Test {
	
	private final void test(int a) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		TestInher ti = new TestInher();
		ti.test(12);
		
	}
	
}
