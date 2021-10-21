package numbersandstring;

public class Test {

	public static void main(String[] args) {

		//test1();
		//test2();
		//test3();
		test4();
	}
	
	public static void test4() {
			
		Integer i = 12;	// autoboxing
		m1(12);			// autoboxing
		
		Integer[] arr = new Integer[]{12,54,213,1323,45,-34};
		
		// unboxing
		for (Integer v : arr) {
			v = v * 2 + 10;
			System.out.println(v);
		}
		
		i.intValue();
	}
	
	public static void m1(Integer i) {
		
	}
	
	public static void test3() {
		
		StringBuilder sb = new StringBuilder("AAAA");
		sb.append("TEST");
		sb.append(false);
		sb.append(12.434343);
		System.out.println(sb);
		
		sb.setLength(10);
		System.out.println(sb);
		
		sb.ensureCapacity(15);
		sb.insert(5, "DUPDA");
		System.out.println(sb);
		
		String a = new String("A");
		String b = new String("A");
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}
	
	public static void test2() {
		
		String n = "This is a test string. Blah blah 123$#@";
		System.out.println(n.charAt(10));
		System.out.println(n.substring(12));
		System.out.println(n.substring(23));
		
		System.out.println("TO jest costam".regionMatches(8, "Ala ma costam", 7, 6));
	}
	
	public static void test1() {

		int a = 0x1b;
		float f = 12.32f;
		double d = 12.32;

		Float fl = 12.32f; // boxing
		Double dbl = 12.32; // boxing

		System.out.println(a);
		if (fl.equals(dbl))
			System.out.println("SAD");

		String val = "12.32";
		Byte b = Float.valueOf(val).byteValue();
		System.out.println(b);

		for (int i = 0; i < 10; i++)
			System.out.println(Math.random());

		// metody klasy Character
		System.out.println(Character.isDigit('C'));
		System.out.println(Character.isWhitespace(' '));

		// manipulacje string
		String str = "test";
		String abc = "test";
		String cba = new String("test");

		if (str == abc)
			System.out.println("str is same as abc");
		if (str == cba)
			System.out.println("str is same as cba");
		if (str.equals(cba))
			System.out.println("str equals cba");
		if (str.equals("test"))
			System.out.println("str equals 'test'");
		if (str == "test")
			System.out.println("str is same as 'test'");

		// nie zmieny obiektu
		System.out.println(str);
		m1(str);
		System.out.println(str);

		// zmieni, bo to inna klasa nie imuttable
		TestInner ti = new Test().new TestInner();
		ti.val = "APUD";
		System.out.println(ti.val);
		m1(ti);
		System.out.println(ti.val);

		// konwersja Number->String
		int i = 12;
		String s1 = "" + i;
		String s2 = String.valueOf(i);
		System.out.println(s1);
		System.out.println(s2);
		int ii = Integer.valueOf("43").intValue();
		System.out.println(ii);
		int iii = Integer.parseInt("5454");
		System.out.println(iii);

	}

	public static void m1(String s) {

		s = "DADS";

	}

	public static void m1(TestInner ti) {

		ti.val = "DUPA";
	}

	private class TestInner {
		String val;
	}

}
