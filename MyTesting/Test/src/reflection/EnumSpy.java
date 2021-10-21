package reflection;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

enum Test {
	A, B, C, D;
}

public class EnumSpy {

	private static final String fmt = "  %11s:  %s %s%n";

	public static void main(String[] args) {

		/*
		 * Class c = Test.class;
		 * 
		 * out.println(c.getName()); out.print(c.isEnum()); Field[] f =
		 * c.getDeclaredFields(); for (Field ff : f) {
		 * out.println(ff.getName()); }
		 */

		Class<?> c = Test.class;
		if (!c.isEnum()) {
			out.format("%s is not an enum type%n", c);
			return;
		}
		out.format("Class:  %s%n", c);

		Field[] flds = c.getDeclaredFields();
		List<Field> cst = new ArrayList<Field>(); // enum constants
		List<Field> mbr = new ArrayList<Field>(); // member fields
		for (Field f : flds) {
			if (f.isEnumConstant())
				cst.add(f);
			else
				mbr.add(f);
		}
		if (!cst.isEmpty())
			print(cst, "Constant");
		if (!mbr.isEmpty())
			print(mbr, "Field");

		Constructor[] ctors = c.getDeclaredConstructors();
		for (Constructor ctor : ctors) {
			out.format(fmt, "Constructor", ctor.toGenericString(), synthetic(ctor));
		}

		Method[] mths = c.getDeclaredMethods();
		for (Method m : mths) {
			out.format(fmt, "Method", m.toGenericString(), synthetic(m));
		}
	}

	private static void print(List<Field> lst, String s) {
		for (Field f : lst) {
			out.format(fmt, s, f.toGenericString(), synthetic(f));
		}
	}

	private static String synthetic(Member m) {
		return (m.isSynthetic() ? "[ synthetic ]" : "");
	}

}
