package reflection;

import java.lang.*;
import annot.MetaAnnot;


class Test1 {
	
	static String a;
	
	private String b;
	
	private class Klasa1 {
		
	}
	
	public class Klasa2 {
		IndexOutOfBoundsException i = new IndexOutOfBoundsException();
		
		NullPointerException a;
	}
	
	public static class Klasa3 {
		
		public void test() {
			a = "12";
		}
		
	}
	
	public static void main(String[] args) {
		
		Class[] arr = Test1.class.getClasses();
		
		for (Class c : arr) {
			System.out.println("*** " + c.getName());
		}
		
		Class a = new Test1().getClass();
		Class b = Enu.A.getClass();
		
		System.out.println(a.getName());
		System.out.println(b.getName());
		System.out.println(MetaAnnot.class);
		System.out.println(int[][][].class);
		System.out.println(boolean.class);
		
		
		try {
			
			Class c = Class.forName("reflection.Test1");
			System.out.println(c.getName());
			
			Class d = Class.forName("[B");
			System.out.println(d.getName());

			System.out.println(Klasa1.class);
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("ERROR");
		}
		
		Test2.test();
		
		System.out.println(Double.TYPE);
		System.out.println(Void.TYPE);
		
		System.out.println(a.getSuperclass());
		System.out.println(a.getClasses().length);
		System.out.println(a.getDeclaredClasses().length);
		
		boolean[][] z = new boolean[2][3];
		String[] s = new String[12];
		Test1[] t = new Test1[12];
	
		System.out.println(z.getClass().getName());
		System.out.println(s.getClass().getName());
		System.out.println(t.getClass().getName());
		
	}
	
	enum Enu {
		
		A,B,C,D,E;
	}
	
}
