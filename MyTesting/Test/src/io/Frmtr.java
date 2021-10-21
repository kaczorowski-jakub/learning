package io;
import static java.lang.System.out;

public class Frmtr {
	
	
	public static void test() {
		
		out.format("This is test: %s and this is %d", "dupa", 12);
		out.format("%nInteger %d as hex %x", 12, 12);
		//out.format("%nError %s %s", 2);
		//out.format("%nInteger %d as month name %tB", 2, 2);
		System.out.format("%n%1$+15.6f %n%1$+15.6f %n%1$+15.6f", Math.PI);
		
	}
	
}
