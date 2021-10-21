package interfaces;

public interface I1 {
	
	// stale
	double a = 12.3;	// mozna pominac public static final
	public static final int b = 44;
	
	// sygnatury
	void m1(int i);		// mozna pominac public
	public void m2(int i);
	
	// metoda statyczna
	static double sqr(double base, double power) {
		
		return Math.pow(base, power);
	}
	
	// default
	default void m3(int i) {}
}
