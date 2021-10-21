package inheritance.test3;

public class Test {
	
	public static void main(String[] args) {
		
		T1 t1 = new T1();
		T2 t2 = new T2();
		T1 t3 = t2;
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		System.out.println(t3.a);
	}
	
}
