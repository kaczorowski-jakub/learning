package packages;

import static java.lang.System.out;
//import packages.*; nie zaimportuje Pack2 w packages.pack1
import static packages.pack1.Pack1.ABC;
import static packages.pack1.Pack1.met1;

import packages.pack2.Pack2;


public class Test {
	
	Pack2 pack1;
	
	public static void main(String[] args) {
		
		int a = ABC + 2;
		met1();
		out.println(a);
		
		
	}
	
}
