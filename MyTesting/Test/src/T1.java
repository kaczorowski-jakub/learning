import reflection.FieldSpy;

public class T1 {

	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
		FieldSpy<Integer> fs = new FieldSpy();
	}
	
	private void check(int i) {
		
	}
}
