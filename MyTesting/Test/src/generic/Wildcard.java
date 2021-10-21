package generic;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

	public static <K extends List<Number>> void process(K k) {

		for (Number n : k) {

		}

	}

	public static void process2(List<?> l) {

	}
	
	public static void printList(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	    list.add("DADSA");
	}
	
	public static void printList2(List<?> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	    
	    //list.add(new Object()); // blad
	    list.add(null);
	    list.size();
	}
	
	public static void main(String[] args) {
		
		//printList(new ArrayList<Integer>());
		printList(new ArrayList<Object>());
		printList2(new ArrayList<Integer>());
		
	}
	

}
