package generic;

import java.util.List;

import checker.Test;

public class GenBound <A extends Test>{
	
	A a;
	
	public void test(A a){
		HIJ<Integer> hij;
		
		this.a = a;
	}
	
	public void print() {
		System.out.println(a);
	}
	
	public static <K extends Number> boolean test(K k) {
						
		return k.equals(new Object());
		
	}
	
	private class ABC <A extends String, B extends Integer> {
		
	}
	
	private class EFG <A extends String & TestInt, B extends Integer> {
		
	}
	
	private class HIJ <A extends Number> {
		
	}
	
	
	
}
