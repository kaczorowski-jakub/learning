package inheritance.test5;

public class T1 {

	int a;
	boolean b;
	String c;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("KILL " + this);
	}
	
	@Override
	public String toString() {
		return "a:" + a + "\nb:" + b + "\nc:" + c;
	}

	@Override
	protected Object clone() {

		T1 t1 = new T1();
		t1.setA(a);
		t1.setB(b);
		t1.setC(c);
		return t1;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof T1) {
			T1 t1 = (T1) obj;
			if (t1.a == this.a) return true;
			
		}
		return false;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

}
