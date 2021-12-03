package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import static java.lang.System.out;


public class MethodSpy<T> {
	
	public T val;
	private int e;
	int f = 12;
	public static final int b = 12;
	public final double c = 12.3232;
	protected float d = 12.32f;
	public static int t = 1;
	
	private static class TTT {
		
		public void test() {
			t =122;
		}
	}
	
	enum ABC {
		A,B,C,D;
	}
	
	public static void main(String... strings) {
	    Class<String> abcdef = String.class;
		Class<MethodSpy> c = MethodSpy.class;
		/*
		for (Constructor<?> k : c.getDeclaredConstructors()) {
			out.println(k.getName());
			out.println(k.isSynthetic());
			
			for (Parameter p : k.getParameters()) {
				out.print(p.getType());
				out.print(", " + p.getName());
				out.print(", " + p.getModifiers());
				out.print(", " + p.isImplicit());
				out.print(", " + p.isSynthetic());
				out.println("");
			}
		}
		out.println("==================");
		*/
		
		for (Method m : c.getDeclaredMethods()) {
			out.println(m.isSynthetic());
			out.println(m.getName());
			out.println(m.toGenericString());
			out.println(m.getReturnType());
			out.println(m.getModifiers());
			out.println(m.isVarArgs());
			
			String[] a = new String[]{"SAD","DAD"};
			
			if (m.getName().equals("test0")) {
				try {
					Object o = m.invoke(new MethodSpy<String>(), 12);
					System.out.println(o);
				}
				catch (InvocationTargetException e) {}
				catch (IllegalAccessException e) {}
			}
			
			if (m.getName().equals("test3")) {
				try {
					Object o = m.invoke(new MethodSpy<String>(), "A");
					System.out.println(o);
				}
				catch (InvocationTargetException e) {}
				catch (IllegalAccessException e) {}
			}
			
			if (m.getName().equals("test1")) {
				try {
					Object o = m.invoke(new MethodSpy<String>(), 12, a);
					System.out.println(o);
				}
				catch (InvocationTargetException e) {}
				catch (IllegalAccessException e) {}
			}

			if (m.getName().equals("dupa")) {
				try {
					Object o = m.invoke(new MethodSpy<String>(),null);
					System.out.println(o);
				}
				catch (InvocationTargetException e) {}
				catch (IllegalAccessException e) {}
			}
			
			for (Parameter p : m.getParameters()) {
				out.print(p.getType());
				out.print(", " + p.getName());
				out.print(", " + p.getModifiers());
				out.print(", " + p.isImplicit());
				out.print(", " + p.isSynthetic());
				out.println("");
			}
			
			out.println("------------");
			
		}
		
		
	}
	
	private String test0(int a) {
		//test12(12);
		test1(1);
		String[] b = new String[10];
		test1(1,b);
		
		return "CCCC";
	}
	
	private void test10(int a, int b, int c, int...d) {
		
	}
	
	private String test1(int a, String...b) {
		
		return "A:";
		
	}
	
	private String test12(int a, String[] b) {
		
		return "A:";
		
	}
	
	private void test2(int a, double b, final float c, String d) {
		
	}
	
	private int dupa() {
		return 12;
	}
	
	private String test3(String ala) {
		return "ALA M AKOTA";
	}
	
}