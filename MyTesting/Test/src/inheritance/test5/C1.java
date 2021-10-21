package inheritance.test5;

public class C1 {
	
	int a;
	boolean b;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	};
	
	@Override
	public int hashCode() {
		return a + (b ? 1 : 0);
	}
	
}
