package inheritance.test;

/**
 * class method is more important than default method in interface
 * @author jakub.kaczorowski
 *
 */
public class CT2 extends CT1 implements IT1{
	
	public static void main(String[] args) {
		CT2 ct2 = new CT2();
		ct2.m1();
		
	}
	
}
