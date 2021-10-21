package interfaces;

public interface Default1 {
	
	void m1();
	void m2();
	default void m3() {
		System.out.println("Default m3");
	}
	
	static void m4(int a) {
		
	}
	
}
