package inheritance.test5;

public class Test {

	public static void main(String[] args) {

		T1 t1 = new T1();
		t1.setA(1);
		t1.setB(true);
		t1.setC("ALA MA KOTA");
		T1 t2 = (T1) t1.clone();
		t1.setA(2);
		t1.setB(false);
		t1.setC("KOT MA ALE");
		System.out.println(t1);
		System.out.println(t2);

		if (t1.equals(t2))
			System.out.println("rowne");
		else
			System.out.println("nierowne");

		t1.setA(1);
		if (t1.equals(t2))
			System.out.println("rowne");
		else
			System.out.println("nierowne");
		
		
		C1 c10 = new C1();
		c10.a = 1;
		c10.b = false;
		C1 c11 = new C1();
		c11.a = 1;
		c11.b = false;
		if (c10.equals(c11))
			System.out.println("rowne");
		else
			System.out.println("nierowne");
		
		

	}

}
