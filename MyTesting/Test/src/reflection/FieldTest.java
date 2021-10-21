package reflection;

import annot.Test;
import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldTest {
	
	public static void main(String... args){
		Class c = Test.class;
		
		out.println("\nDeclared fields:");
		for (Field f : c.getDeclaredFields()) {
			out.println(f.getName());
		}
		
		out.println("\nFields:");
		for (Field f : c.getFields()) {
			out.println(f.getName());
		}
		
		out.println("\nDeclared methods:");
		for (Method m : c.getDeclaredMethods()) {
			out.println(m.getName());
		}
		
		out.println("\nMethods:");
		for (Method m : c.getMethods()) {
			out.println(m.getName());
		}
		

	}
	
	
	
	
}
