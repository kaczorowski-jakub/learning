package interfaces;

public interface FunctionalInterface2 {
	
	public void m1();
	default public void m2() {
		
		try {
			
		} catch(NullPointerException | IndexOutOfBoundsException ex) {
			
		}
		
	}
}
