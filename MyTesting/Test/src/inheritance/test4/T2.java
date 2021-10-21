package inheritance.test4;

public class T2 extends T1 {

	int a;

	void m1() {
		System.out.println("m1 in T2");
	}
	
	/*public Class<T2> getClass(){
		
	}*/
	
	void test() {
		
		this.a = 12;
		super.a = 32;
		super.m1();
		this.m1();
		
	}

	public static void main(String[] args) {

	}

}
