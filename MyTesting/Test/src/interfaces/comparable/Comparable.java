package interfaces.comparable;

public interface Comparable {
	
	public int compare(Comparable c1);
	
	public default void printSmthg() {
		System.out.println("SDDS");
	}
	
}
