package collectns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import collectns.Test1.Cmp;

/**
 * Streams
 * 
 * @author jakub.kaczorowski
 *
 */
public class Strm {

	public static void main(String[] args) {

		// test1();
		test2();
	}

	/**
	 * Pararell streams
	 */
	public static void test2() {

		List<Test1.Cmp> l = new ArrayList<>();
		l.addAll(Arrays.asList(new Test1.Cmp[] { new Test1.Cmp("Jan", "Kowalski"),
				new Test1.Cmp("Jakub", "Kaczorowski"), new Test1.Cmp("Marek", "Browarek") }));
		for (int i = 0; i < 100; i++) {
			l.add(new Test1.Cmp("A" + Math.random(), "B" + Math.random()));
		}
		System.out.print("Original value: ");
		l.stream().forEach(a -> System.out.print(a + ","));

		System.out.print("\nParallel order (function refference): "
				+ l.parallelStream().collect(Collectors.groupingByConcurrent(Test1.Cmp::getSex)));
		System.out.print("\nParallel order: (lambda expression)"
				+ l.parallelStream().collect(Collectors.groupingByConcurrent(a -> ((Test1.Cmp) a).getSex())));
		System.out.print("\nParallel order: (anonymous class)"
				+ l.parallelStream().collect(Collectors.groupingByConcurrent(new Function<Test1.Cmp, String>() {

					@Override
					public String apply(Cmp t) {
						return t.getSex();
					}
				})));

		List<Integer> ll = new ArrayList<>();
		ll.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.print("\nInteger list: " + ll);
		System.out.print("\nInteger list parallel: ");
		ll.parallelStream().forEach(a -> System.out.print(a + ","));
		System.out.print("\nInteger list parallel forEachOrdered: ");
		ll.parallelStream().forEachOrdered((a -> System.out.print(a + ",")));
	}

	/**
	 * Streams
	 */
	public static void test1() {

		List<Test1.Cmp> l = new ArrayList<>();
		l.addAll(Arrays.asList(new Test1.Cmp[] { new Test1.Cmp("Jan", "Kowalski"),
				new Test1.Cmp("Jakub", "Kaczorowski"), new Test1.Cmp("Marek", "Browarek") }));

		Test1.print(">=20:");
		l.stream().filter(p -> p.age >= 20).forEach(p -> System.out.print(p + ", "));

		Test1.print("\nage average: ");
		System.out.print(l.stream().mapToInt(p -> p.age).average().getAsDouble());

		Test1.print("\nage sum: ");
		System.out.print(l.stream().mapToInt(p -> p.age).sum());

		Test1.print("\nage reduce: ");
		System.out.print(l.stream().mapToInt(p -> p.age).reduce(0, (a, b) -> b - a));

		Integer totalAgeReduce = l.stream().map(new TT()).reduce(1, (a, b) -> a * b);
		Test1.print("\nage reduce using new class: " + totalAgeReduce);

		Integer totalAgeReduce2 = l.stream().map(new Function<Test1.Cmp, Integer>() {
			@Override
			public Integer apply(Cmp t) {
				return t.age;
			}
		}).reduce(0, (a, b) -> a + b);
		Test1.print("\nage reduce using anonymus class: " + totalAgeReduce2);

		Cmp c = l.stream().reduce(new Test1.Cmp("", "", 0), new BinaryOperator<Test1.Cmp>() {

			@Override
			public Cmp apply(Cmp t, Cmp u) {

				t.age = t.age + u.age;
				return t;
			}
		});
		Test1.print("\nage sum reduce using anonymous clss: " + c.age);

		Avr avr = l.stream().collect(Avr::new, Avr::accept, Avr::combine);
		Test1.print("\nage average collect: " + avr.avr());

		Test1.print("\n" + l.stream().collect(Collectors.groupingBy(Test1.Cmp::getSex)));

	}

	private static class Avr implements Consumer<Test1.Cmp> {

		int total;
		int cnt;

		public double avr() {
			return total / cnt;
		}

		@Override
		public void accept(Cmp t) {
			total += t.age;
			cnt++;

		}

		public void combine(Avr a) {
			total += a.total;
			cnt += a.cnt;
		}
	}

	private static class TT implements Function<Test1.Cmp, Integer> {

		public Integer apply(Test1.Cmp c) {

			return c.getAge();

		};

	}

}
