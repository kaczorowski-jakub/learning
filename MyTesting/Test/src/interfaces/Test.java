package interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

import interfaces.comparable.Comparable;
import interfaces.comparable.ComparableImp;

public class Test {
	
	String a;
	
	public static void main(String[] args) {

		// Type way of comparing
		ComparableImp c1 = new ComparableImp();
		ComparableImp c2 = new ComparableImp();
		c1.setVal(12);
		c2.setVal(14);
		System.out.println(c1.compare(c2));
		System.out.println("Largest: " + findLargest(c1, c2));

		// Generic way of comparing
		interfaces.comparable.generic.ComparableImp ci1 = new interfaces.comparable.generic.ComparableImp();
		interfaces.comparable.generic.ComparableImp ci2 = new interfaces.comparable.generic.ComparableImp();

		ci1.val = 29;
		ci2.val = 12;
		System.out.println(ci1.compare(ci2));
		c1.printSmthg();

		// functional interface - lambda expressions
		FunctionalInterface fi11 = new FunctionalInterface() {
			public void m1(int i) {

			}

		};
		FunctionalInterface fi12 = i -> {
			i++;
		};
		FunctionalInterface2 fi21 = () -> {
			int a = 2 + 4;
			a++;
			a--;
		};
		FunctionalInterface fi13 = Test::ttt;
		
		FunctionalInterface3 fi31 = (a,b) -> {return a+b;};
		
		String a = "ADAS";
		Test t = new Test();
		t.m1("String");
		t.m1(12);
		t.m1(12.23);
		
		Arrays.sort(new String[]{"A","B"},String::compareTo);
		Arrays.sort(new String[]{"A","B"},(a1,b1) -> {return 1;});
		FunctionalInterface4 fi4 = Test::comp;
		test123(() -> {return new FI4I();}, 3);
		test123(FI4I::new, 3);
		
		
	}
	
	public static void ttt(int a) {
		
		Test[] ab = new Test[]{new Test(), new Test()};
		
	}
	
	public static void test123(FunctionalInterface5 fi5, int a) {
		
	}
	
	public int comp(String a) {
		return 1;
	}
	
	public void m1(Object o1) {System.out.println("Object");}
	public void m1(Number o1) {System.out.println("Number");}
	public void m1(Integer o1) {System.out.println("Integer");}
	
	private static Object findLargest(Object o1, Object o2) {

		Comparable c1 = (Comparable) o1;
		Comparable c2 = (Comparable) o2;

		if (c1.compare(c2) > 0)
			return o1;
		else
			return o2;

	}

	private static Object findSmallest(Object o1, Object o2) {

		Comparable c1 = (Comparable) o1;
		Comparable c2 = (Comparable) o2;

		if (c1.compare(c2) < 0)
			return o1;
		else
			return o2;

	}
}
