package reflection;

import java.lang.reflect.Method;

public class Test2{

	
	public static void test() {
		
		try {
			Class e = Class.forName("reflection.Test1$Klasa2");
			System.out.println(e);
			
			Class f = Class.forName("reflection.Test1");
			for (Class c : f.getDeclaredClasses()) {
				System.out.println(c);
				
			}
			
			for (Method m : f.getDeclaredMethods()) {
				System.out.println(m.getName());
			}
		}
		catch(ClassNotFoundException e) {
			
			System.out.println("ERROR - Test2");
			
		}
		
	}
	
}
