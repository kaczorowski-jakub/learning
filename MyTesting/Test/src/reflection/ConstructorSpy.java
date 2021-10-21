package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Arrays;

import static java.lang.System.out;

public class ConstructorSpy {
	
	private void type(){
		out.println("TET");
	}
	
	class RT {
		public RT() {
			
		}
	}
	
	public ConstructorSpy() {
		
	}
	
	public ConstructorSpy(int a) {
		
	}
	
	public static void t1() {
		
		Class<?> c = (new String[10]).getClass();
		//Class<?> c = ConstructorSpy.class;
		out.println(c.getName());
		out.println(c.isArray());
		out.println(c.getComponentType());
		Constructor[] ca = c.getDeclaredConstructors();
		for (Constructor con : ca) {
			out.println(con.getName() + " - " + con.getParameterTypes());
			
		}
	}
	
	public static void t2() {
		
		Object arr = Array.newInstance(Integer.TYPE, 15);
		for (int i = 0 ; i < 15 ; i++) {
			Array.set(arr, i, i);
		}
		
		int[] ar = (int[]) arr;
		out.println(Arrays.toString(ar));
		
	}
	
	public static void t3() {
		
		/*Object matrix = Array.newInstance(Array.newInstance(String.class, 4).getClass(), 3);
		Object row0 = Array.newInstance(String.class, 4);
		Object row1 = Array.newInstance(String.class, 4);
		Object row2 = Array.newInstance(String.class, 4);
		
		Array.set(row0, 0, "Row0 - Value 0");
		Array.set(row0, 1, "Row0 - Value 1");
		Array.set(row0, 2, "Row0 - Value 2");
		Array.set(row0, 3, "Row0 - Value 3");
		
		Array.set(row1, 0, "Row1 - Value 0");
		Array.set(row1, 1, "Row1 - Value 1");
		Array.set(row1, 2, "Row1 - Value 2");
		Array.set(row1, 3, "Row1 - Value 3");
		
		Array.set(row2, 0, "Row2 - Value 0");
		Array.set(row2, 1, "Row2 - Value 1");
		Array.set(row2, 2, "Row2 - Value 2");
		Array.set(row2, 3, "Row2 - Value 3");
		
		Array.set(matrix, 0, row0);
		Array.set(matrix, 1, row1);
		Array.set(matrix, 2, row2);
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 4 ; j++) {
				out.println(Array.get(Array.get(matrix, i),j));
			}
		}*/
		
		/*Object matrix = Array.newInstance(String.class, 3, 4);
		Object row0 = Array.get(matrix, 0);
		Object row1 = Array.get(matrix, 1);
		Object row2 = Array.get(matrix, 2);
		
		Array.set(row0, 0, "Row0 - Value 0");
		Array.set(row0, 1, "Row0 - Value 1");
		Array.set(row0, 2, "Row0 - Value 2");
		Array.set(row0, 3, "Row0 - Value 3");
		
		Array.set(row1, 0, "Row1 - Value 0");
		Array.set(row1, 1, "Row1 - Value 1");
		Array.set(row1, 2, "Row1 - Value 2");
		Array.set(row1, 3, "Row1 - Value 3");
		
		Array.set(row2, 0, "Row2 - Value 0");
		Array.set(row2, 1, "Row2 - Value 1");
		Array.set(row2, 2, "Row2 - Value 2");
		Array.set(row2, 3, "Row2 - Value 3");
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 4 ; j++) {
				out.println(Array.get(Array.get(matrix, i),j));
			}
		}*/
		
		Object matrix = Array.newInstance(String.class, 2, 3, 1);
		Object row0 = Array.get(matrix, 0);
		Object row1 = Array.get(matrix, 1);
		Object row00 = Array.get(row0, 0);
		Object row01 = Array.get(row0, 1);
		Object row02 = Array.get(row0, 2);
		Object row10 = Array.get(row1, 0);
		Object row11 = Array.get(row1, 1);
		Object row12 = Array.get(row1, 2);
		
		Array.set(row00, 0, "[0,0,0]");
		Array.set(row01, 0, "[0,1,0]");
		Array.set(row02, 0, "[0,2,0]");
		
		Array.set(row10, 0, "[1,0,0]");
		Array.set(row11, 0, "[1,1,0]");
		Array.set(row12, 0, "[1,2,0]");
		
		
		for (int i = 0 ; i < 2 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				for (int k = 0 ; k < 1 ; k++) {
					out.println(Array.get(Array.get(Array.get(matrix, i), j), k));
				}
			}
		}
	}
	
	public static void main(String... args) {
		
		
		
		//t1();
		//t2();
		t3();
		if (true) return;
		
		Class<?> c = ConstructorSpy.class;
		
		try {
			ConstructorSpy cs = (ConstructorSpy) c.newInstance();
			cs.type();
		} catch(Exception e) {
			out.println("ERROR");
		}
		
		Class<?> d = RT.class;
		
		try {
			RT cs = (RT) d.newInstance();
		} catch(Exception e) {
			out.println("ERROR");
		}
		
		try {
			Constructor abc = ConstructorSpy.class.getDeclaredConstructor(Integer.TYPE);
			ConstructorSpy rt = (ConstructorSpy) abc.newInstance(12);
			
			Constructor abcd = ConstructorSpy.class.getDeclaredConstructor();
			ConstructorSpy rtd = (ConstructorSpy) abcd.newInstance();
		} catch(Exception e) {
			out.println("ERROR");
		}
		
		/*
		
		try {
			Class<?> cArg = Class.forName(args[1]);

			Class<?> c = Class.forName(args[0]);
			Constructor[] allConstructors = c.getDeclaredConstructors();
			for (Constructor ctor : allConstructors) {
				Class<?>[] pType = ctor.getParameterTypes();
				for (int i = 0; i < pType.length; i++) {
					if (pType[i].equals(cArg)) {
						out.format("%s%n", ctor.toGenericString());

						Type[] gpType = ctor.getGenericParameterTypes();
						for (int j = 0; j < gpType.length; j++) {
							char ch = (pType[j].equals(cArg) ? '*' : ' ');
							out.format("%7c%s[%d]: %s%n", ch, "GenericParameterType", j, gpType[j]);
						}
						break;
					}
				}
			}

			// production code should handle this exception more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
		*/
	}

}
