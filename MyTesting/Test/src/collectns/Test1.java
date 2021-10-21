package collectns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test1 {

	public static void print(String s) {
		System.out.print(s + ",");
	}

	public static String map(String s) {
		return ((char) (s.charAt(0) + 5)) + "";
	}

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
	}
	
	/**
	 * Sorted Set
	 */
	public static void test9() {

		Collection<Object> c = new ArrayList<>();
		c.toArray(new String[0]);
	}

	/**
	 * Ordering
	 */
	public static void test8() {

		List<String> list = new ArrayList<>(Arrays.asList(new String[] { "ALA", "MA", "KOTA" }));
		print("Original: " + list);

		print("\nSorting by list: ");
		list.sort(String::compareTo);

		print("\nUpdated list: ");
		list.addAll(Arrays.asList(new String[] { "DOROTA", "TEZ", "MALPE" }));
		print(list + "");

		print("\nSorting by collections: ");
		Collections.sort(list);
		print(list + "");

		print("\nShuffeled: ");
		Collections.shuffle(list);
		print(list + "");

		print("\nDescending custom sorting: ");
		Collections.sort(list, (a, b) -> {
			return a.compareTo(b) * -1;
		});
		print(list + "");

		List<Cmp> l = new ArrayList<>();
		l.addAll(Arrays.asList(new Cmp[] { new Cmp("Jan", "Kowalski"), new Cmp("Jakub", "Kaczorowski"),
				new Cmp("Marek", "Browarek") }));
		print("\nCustom objects: ");
		print(l + "");

		print("\nCustom sorted objects: ");
		Collections.sort(l);
		print(l + "");

	}

	/**
	 * Map
	 */
	public static void test7() {

		Map<String, Integer> map = new HashMap<>();
		map.put("C", 16);
		map.put("A", 12);
		map.put("D", 18);
		map.put("B", 14);

		print("initial hash map: ");
		map.keySet().stream().forEach((key) -> print(map.get(key).toString()));

		print("\ninitial tree map: ");
		Map<String, Integer> mapT = new TreeMap<>(map);
		mapT.keySet().stream().forEach((key) -> print(mapT.get(key).toString()));

		print("\ninitial linked hash map: ");
		Map<String, Integer> mapL = new LinkedHashMap<>(map);
		mapL.keySet().stream().forEach((key) -> print(mapL.get(key).toString()));

		print("\ncontains key A: " + map.containsKey("A"));
		print("\ncontains key A: " + map.containsKey("F"));

		print("\nOverrides: ");
		Map<String, Integer> mapTT = new TreeMap<>();
		mapTT.put("B", 32);
		mapTT.put("D", 66);
		map.putAll(mapTT);
		map.keySet().stream().forEach((key) -> print(map.get(key).toString()));

		print("\nKey Set: ");
		for (String s : mapT.keySet())
			print(s);

		print("\nValue Set: ");
		for (Integer v : mapT.values())
			print(v + "");

		print("\nEntry Set: ");
		for (Entry<String, Integer> e : mapT.entrySet())
			print(e + "");

		print("\nSame value: ");
		mapTT.put("Z", 66);
		print(mapTT + " ");
		mapTT.keySet().stream().forEach((key) -> print(mapTT.get(key).toString()));

		print("\n map equals mapT: " + map.keySet().equals(mapT.keySet()));
		print("\n map equals mapTT: " + map.keySet().equals(mapTT.keySet()));

		print("\n Multimap: ");
		Map<String, List<String>> mm = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			mm.put(i + "", Arrays.asList(new String[] { (char) (i + 50) + "", (char) (i + 5 + 50) + "" }));
		}
		print(mm + "");

	}

	/**
	 * Deque
	 */
	public static void test6() {

		Deque<String> d = new LinkedList<>();

		print("Original queue: ");
		d.addAll(Arrays.asList(new String[] { "D", "C", "B", "X", "Y", "Z" }));
		d.stream().forEach(Test1::print);

		print("\nAdd O element as first: ");
		d.addFirst("O");
		d.stream().forEach(Test1::print);

		print("\nAdd O element as last: ");
		d.addLast("A");
		d.stream().forEach(Test1::print);

		print("\nPeek first: " + d.peekFirst());
		print("\nPeek last: " + d.peekLast());

		print("\nNew list: ");
		d.addFirst("A");
		d.stream().forEach(Test1::print);
		print("\nRemove first occ. of A returns: " + d.removeFirstOccurrence("A") + " and the coll. is: ");
		d.stream().forEach(Test1::print);
		print("\nRemove last occ. of A returns: " + d.removeFirstOccurrence("A") + " and the coll. is: ");
		d.stream().forEach(Test1::print);
		print("\nRemove last occ. of A returns: " + d.removeFirstOccurrence("A") + " and the coll. is: ");
		d.stream().forEach(Test1::print);
	}

	/**
	 * Queue
	 */
	public static void test5() {

		Queue<String> q = new LinkedList<>();

		print("Original queue: ");
		q.addAll(Arrays.asList(new String[] { "D", "C", "B", "X", "Y", "Z" }));
		q.stream().forEach(Test1::print);

		print("\nAdd F: ");
		q.add("F");
		q.stream().forEach(Test1::print);

		print("\nPeek element (" + q.peek() + "): ");
		q.stream().forEach(Test1::print);

		print("\nPoll element (" + q.poll() + "): ");
		q.stream().forEach(Test1::print);

		q.clear();
		print("\npoll from empty queue is " + (q.poll() == null ? "null" : "other"));
		print("\nremove from empty queue is " + q.remove());
	}

	/**
	 * List
	 */
	private static void test4() {

		List<String> l = new ArrayList<>(Arrays.asList(new String[] { "A", "B", "C", "D", "A", "D" }));
		print("Original list: ");
		l.stream().forEach(Test1::print);

		print("\nRemoved A from list: ");
		l.remove("A");
		l.stream().forEach(Test1::print);

		print("\nAdded B to list: ");
		l.add("B");
		l.stream().forEach(Test1::print);

		print("\nCompare to B,C,D,A,B,D (different order): ");
		print(l.equals(Arrays.asList(new String[] { "B", "C", "D", "A", "B", "D" })) + "");

		print("\nCompare to B,C,D,A,B,D (the same): ");
		print(l.equals(Arrays.asList(new String[] { "B", "C", "D", "A", "D", "B" })) + "");

		print("\nadd L:");
		l.add("L");
		l.stream().forEach(Test1::print);

		print("\nset 2=Z:");
		l.set(2, "Z");
		l.stream().forEach(Test1::print);

		print("\nIterator:");
		ListIterator<String> i = l.listIterator();
		while (i.hasNext()) {
			print(i.next());
		}
		while (i.hasPrevious()) {
			print(i.previous());
		}

		print("\nSublist 2-4:");
		l.subList(2, 4).stream().forEach(Test1::print);

		print("\nSublist 2-4 clear:");
		l.subList(2, 4).clear();
		l.stream().forEach(Test1::print);

		l.addAll(Arrays.asList(new String[] { "A", "G" }));
		print("\nnew list:");
		l.stream().forEach(Test1::print);

		print("\nsorted list:");
		// l.sort(String::compareTo);
		Collections.sort(l);
		l.stream().forEach(Test1::print);

		print("\nreversed list:");
		Collections.reverse(l);
		l.stream().forEach(Test1::print);

		print("\nshuffeled list:");
		Collections.shuffle(l);
		l.stream().forEach(Test1::print);

		print("\nMap: ");
		l.stream().map(Test1::map).forEach(Test1::print);

	}

	/**
	 * Set
	 */
	private static void test3() {

		Set<String> s = new HashSet<>();

		System.out.println("\nAdd to set:");
		System.out.println(s.add("A"));
		System.out.println(s.add("B"));
		System.out.println(s.add("C"));
		System.out.println(s.add("A")); // tego nie uda sie dodac, bo juz
										// istnieje

		System.out.println("\nCreating set from collection:");
		List<String> l = new ArrayList<>();
		l.addAll(Arrays.asList(new String[] { "A", "B", "C", "A" }));
		l.stream().forEach(Test1::print);
		print("\n");
		Set<String> s1 = new HashSet<>(l);
		s1.stream().forEach(Test1::print);

		System.out.println("\n\nOrder:");
		print("HashSet: ");
		new HashSet<String>(Arrays.asList(new String[] { "01", "11", "10" })).stream().forEach(Test1::print);
		print("\nTree: ");
		new TreeSet<String>(Arrays.asList(new String[] { "01", "11", "10" })).stream().forEach(Test1::print);
		print("\nLinkedhashset: ");
		new LinkedHashSet<String>(Arrays.asList(new String[] { "01", "11", "10" })).stream().forEach(Test1::print);

		System.out.println("\n\nMethods:");
		Set<String> s2 = new HashSet<>(Arrays.asList(new String[] { "A", "B", "C" }));
		print("Original: ");
		s2.stream().forEach(Test1::print);
		s2.addAll(Arrays.asList(new String[] { "D", "E" }));
		print("\nAdd new: ");
		s2.stream().forEach(Test1::print);
		s2.addAll(Arrays.asList(new String[] { "D", "E", "F" }));
		print("\nAdd new and existing: ");
		s2.stream().forEach(Test1::print);
		print("\nContains true: ");
		print(s2.containsAll(Arrays.asList(new String[] { "D", "E", "F" })) + "");
		print("\nContains false: ");
		print(s2.containsAll(Arrays.asList(new String[] { "D", "E", "F", "Z" })) + "");
		s2.retainAll(Arrays.asList(new String[] { "E", "F" }));
		print("\nRetain: ");
		s2.stream().forEach(Test1::print);

	}

	/**
	 * Collection
	 */
	private static void test2() {
		Collection<Integer> c1 = new HashSet<>();

		Integer a = 1;
		Integer b = 100;
		Integer c = -123;
		Integer d = 98623;

		c1.add(a);
		c1.add(b);
		c1.add(c);
		c1.add(d);

		Collection<Integer> c2 = new HashSet<>();
		c2.add(a);
		c2.add(b);

		System.out.println(c1.containsAll(c2));

		System.out.println("\nAddAll:");
		c1.addAll(Arrays.asList(new Integer[] { 54, 3232, 6567 }));
		c1.stream().forEach(o -> System.out.println(o));

		System.out.println("\nRemoveAll:");
		c1.removeAll(Arrays.asList(new Integer[] { 54, 3232, 6567 }));
		c1.stream().forEach(o -> System.out.println(o));

		System.out.println("\nRetainAll:");
		c1.retainAll(Arrays.asList(new Integer[] { 100, -123 }));
		c1.stream().forEach(o -> System.out.println(o));

		System.out.println("\nAddAll-Singleton:");
		c1.addAll(Collections.singleton(new Integer(234)));
		c1.stream().forEach(o -> System.out.println(o));

		System.out.println("\nArray:");
		Object[] arr = (Object[]) c1.toArray();
		Arrays.stream(arr).forEach(abc -> System.out.println(abc));
	}

	private static void test1() {
		Collection<String> c = new ArrayList<>();

		c.add("ALA");
		c.add("MA");
		c.add("KOTA");
		c.add("KOT");
		c.add("MA");
		c.add("ALE");

		// strumien
		System.out.println("STREAM:");
		c.stream().forEach(o -> System.out.println(o));

		// for each
		System.out.println("\n---\nFOR-EACH:");
		for (String s : c)
			System.out.println(s);

		// iterator
		System.out.println("\n---\nIterator:");
		Iterator<String> i = c.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}

	public static class Cmp implements Comparable<Cmp> {

		String firstName;
		String lastName;
		int age;
		String sex;

		static int cnt = 10;

		public Cmp() {

			double r = Math.random();
			if (r < 0.5)
				sex = "MALE";
			else
				sex = "FEMALE";
		}

		public Cmp(String firstName, String lastName) {
			this();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = cnt;
			cnt *= 2;
		}

		public Cmp(String firstName, String lastName, int age) {
			this();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;

		}

		@Override
		public int compareTo(Cmp o) {

			if (this.lastName.compareTo(o.lastName) == 0)
				return this.firstName.compareTo(o.firstName);
			else
				return this.lastName.compareTo(o.lastName);
		}

		@Override
		public String toString() {
			return lastName + " " + firstName;
		}

		public int getAge() {
			return this.age;
		}
		
		public String getSex() {
			return this.sex;
		}

	}

}
