package annot;

import java.util.Arrays;
import java.util.List;

@MyAnnotation(author="JK",date="21/02/2012")
public class Test {
	
	@Single("12")
	private String a;
	
	@Single(value="12")
	public String b;
	
	//@Single //error - has to have value
	public int c;
	
	
	@MyAnnotation(author="JK",date="21/02/2012")
	public void testMet1() {
		
	}
	
	@SafeVarargs // Not actually safe!
	 static void m(List<String>... stringLists) {
	   Object[] array = stringLists;
	   List<Integer> tmpList = Arrays.asList(42);
	   array[0] = tmpList; // Semantically invalid, but compiles without warnings
	   String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
	   System.out.println(s);
	   
	   FunctInterf fi = ((int a) -> false);
	   
	 }
	
	
	
	public void t1() {
		
	}
	
	@Type(MetaAnnot.A1)
	@Type(MetaAnnot.A2)
	public void met1() {
		
	}
	
	
	int aaa;
}
