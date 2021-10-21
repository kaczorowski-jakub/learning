package collectns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algor {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {

		List<String> l = Arrays.asList("Ala ma kota a kot ma ale".split(" "));
		List<String> t = new ArrayList<>(l);

		System.out.println("Original list: " + t);
		
		t = new ArrayList<>(l);
		Collections.sort(t);
		System.out.println("Sorted list: " + t);
		
		t = new ArrayList<>(l);
		Collections.reverse(t);
		System.out.println("Reverse list: " + t);
		
		t = new ArrayList<>(l);
		Collections.fill(t, "DUPA");
		System.out.println("Fill with DUPA: " + t);
		
		t = new ArrayList<>(l);
		Collections.swap(t, 0, 4);
		System.out.println("Swap Ala and kot: " + t);
		
		t = new ArrayList<>(l);
		System.out.println("Search 'ale' in not sorted list: " + Collections.binarySearch(t, "ale"));
		
		t = new ArrayList<>(l);
		Collections.sort(t);
		System.out.println("Search 'ale' in not sorted list: " + Collections.binarySearch(t, "ale"));
		
		System.out.println("Frequency of 'ma': " + Collections.frequency(l, "ma"));
		System.out.println("Disjoint of t and l: " + Collections.disjoint(l, t));
		System.out.println("Disjoint of l and empty: " + Collections.disjoint(l, new ArrayList<>()));
		System.out.println("Min: " + Collections.min(l));
		System.out.println("Max: " + Collections.max(l));
	}

}
