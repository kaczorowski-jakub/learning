package collectns;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hashing {

	String id1;
	int id2;

	String val1;
	String val3;

	@Override
	public int hashCode() {

		return Objects.hash(id1, id2);

	}

	public static void main(String[] args) {

		System.out.println("TEST#1:");
		// String
		T1 t11 = new T1();
		t11.a = "ALA";
		t11.b = "A";
		T1 t12 = new T1();
		t12.a = "ALA";
		t12.b = "B";
		System.out.println(t11.hashCode());
		System.out.println(t12.hashCode());
		System.out.println(t11.equals(t12)); // nie sa rowne, maja tylko ten sam
												// hashCode
		Set<T1> set = new HashSet<>();
		set.add(t11);
		set.add(t12);
		System.out.println(set);
		System.out.println(set.size());
		set.remove(t12);					// usuwany jest poprawny element
		System.out.println(set);
		
		T1 t13 = new T1();
		t13.a = "ALA";
		t13.b = "A";
		System.out.println(t11.equals(t13));	// nie sa rowne
		
		T1 t14 = t11;
		System.out.println(t11.equals(t14));	// sa rowne
		
		// int
		T2 t21 = new T2();
		t21.a = 1;
		T2 t22 = new T2();
		t22.a = 1;
		
		System.out.println("\nTEST#2:");
		System.out.println(t21.hashCode());
		System.out.println(t22.hashCode());
		System.out.println(t21.equals(t22));	// sa rowne
		Set<T2> set1 = new HashSet<>();
		set1.add(t21);
		set1.add(t22);
		System.out.println(set1.size());	// bedzie jeden wpis w set

	}

	private static class T1 {

		String a;
		String b;

		@Override
		public int hashCode() {
			return a.hashCode();
		}
		
		@Override
		public String toString() {
			return a + ":" + b;
		}
	}

	private static class T2 {

		int a;

		@Override
		public int hashCode() {
			return a;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if (obj == null) return false;
			else if (! (obj instanceof T2)) return false;
			
			return this.hashCode()==obj.hashCode();
		}
	}

}
