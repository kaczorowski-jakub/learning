package inheritance;

public class T2 extends T1{
	
	private int a;
	
	public T2() {
		
		T11 t11 = new T11();
		//T12 t12 = new T12();
		this.a = 1;
		super.a = 2;
		
	}
	
	public void m2(){}
	
	//public void m3(){}
	

	/*public int metoda1(int a) {
		
		return 1;
	}*/
	
	public static void m3(){ System.out.println("static m3 in T2");}
}
