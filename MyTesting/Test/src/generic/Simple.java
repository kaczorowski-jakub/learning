package generic;

import static java.lang.System.out;

public class Simple <T>{

	T t;
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	public static void main(String[] args) {
		
		Simple<String> s = new Simple<>();
		s.setT("SDSADSA");
		out.println(s.getT());
	}
	
	
	
}
