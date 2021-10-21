public class example {
	int i[] = { 0 };

	public static void main(String args[]) {
		int i[] = { 1 };
		change_i(i);
		System.out.println(i[0]);

		A a = new example().new A();
		a.a = 12;
		System.out.println(a.a);
		
		final int abc = 12;
		final A b;
		b = new example().new A();
	}

	public static void change_i(int i[]) {
		int j[] = { 2 };
		i = j;
	}

	public static void change_a(A a) {

		A b = new example().new A();
		b.a = 432;
		a = b;

	}

	class A {

		int a;
	}
}