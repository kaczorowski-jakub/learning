package inheritance;

public class Test {

	public static void main(String[] args) {
		
		T1 t1 = new T1();
		
		T1.T10 t10 = t1.new T10();
		T1.T11 t11 = t1.new T11();
		T1.T14 t14 = new T1.T14();
	}

}
