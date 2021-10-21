package reflection;

import static java.lang.System.out;

import java.lang.reflect.Modifier;

public class Test3 {

	public static void main(String[] args) {

		Class c = java.util.concurrent.ConcurrentNavigableMap.class;

		out.format("Class:%n  %s%n%n", c.getCanonicalName());
		out.format("Modifiers pure:%n   %s%n%n)", c.getModifiers());
		out.format("Modifiers:%n   %s%n%n)", Modifier.toString(c.getModifiers()));

	}

}
