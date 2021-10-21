package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

public class FieldSpy<T> {
	
	public T val;
	private int e;
	int f = 12;
	public static final int b = 12;
	public final double c = 12.3232;
	protected float d = 12.32f;

	public static void main(String... strings) {

		Class c = FieldSpy.class;
		FieldSpy fs = new FieldSpy();
		Test1 t1 = new Test1();
		
		for (Field f : c.getDeclaredFields()) {

			out.println(f.getName());
			out.println("Modyfikatory: " + f.getModifiers() + "(" + Modifier.toString(f.getModifiers()) + ")");
			out.println("Typ:          " + f.getType());
			out.println("GenericType:  " + f.getGenericType());
			out.println("");
			
		}
		
		try {
			Field f = c.getDeclaredField("f");
			f.setInt(fs, 12);
			
			f = t1.getClass().getDeclaredField("a");
			f.set(t1, "DSDSDS");
			
			// b jest private
			f = t1.getClass().getDeclaredField("b");
			f.set(t1, "DSDSDS");
		}
		catch(IllegalAccessException e ){
			out.println("ILLEGAL ACCESS");
		}
		catch(NoSuchFieldException e) {
			out.println("NSF");
		}
		
		out.println(b);

	}

}