package generic;

import java.util.ArrayList;
import java.util.List;

public class LowerBound<K extends Integer> {
	
	private Comparable<K> c;
	
	public static void main(String[] args) {
		
		//List<Number> i = new ArrayList<Integer>();
		//List<? super Number> ii = new ArrayList<Integer>();
		List<? super Number> ii = new ArrayList<Object>();
		//List<? extends Number> iii = new ArrayList<Object>();
		List<? extends Number> iii = new ArrayList<Integer>();
		
		List<? super Integer> iv = new ArrayList<>();
		//iv.add((Number) 12);
		//ii.add(new Object());
		ii.add(12);
		test2(new Integer(12));
		
		List<? super TestInt> v;
		
		test(new ArrayList<Object>());
		test(new ArrayList<Number>());
		test(new ArrayList<Integer>());
		//test(new ArrayList<String>());
		
		//test3(new ArrayList<Number>());
		test4(new ArrayList<Number>());
		
		List<Integer> le = new ArrayList<>();
//		List<? extends Number> ln = le;
//		ln.add((Number) 35);
		List<? extends Number> ln = new ArrayList<>();
		//ln.add((Number)35);
		
	}
	
	public static void test(List<? super Integer> a) {
		a.add(12);
	}
	
	public static void test3(List<Integer> a) {
		
	}
	
	public static void test4(List<? super Integer> a) {
		
	}
	
	public static void test2(Object i) {
		
	}
	
	public void test3() {
		
		
		
	}
}
