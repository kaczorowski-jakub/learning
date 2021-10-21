package inheritance.subpack;

import inheritance.T1;
import inheritance.T2;

public class Test2 extends T1{
	
	public static void main(String[] args) {
		T1.T11 t11;
		T1 t1 = new T1();
		T2 t2 = new T2();
		T1 t3 = t2;
		
		t1.m3();
		t2.m3();
		t3.m3();
		
		T1 a = new T2();
		System.out.println(a.a);
	}
	
	private void m1() {
		
		
	}
	
}
