package checker;

import org.checkerframework.checker.nullness.qual.Nullable;

public class Test {

	public static void main(String[] args) {
		
		test(null);
	}
	
	private static void test(@Nullable String a) {
		
		System.out.println(a.toString());
		
	}
	
}
