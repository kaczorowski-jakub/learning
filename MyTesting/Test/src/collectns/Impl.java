package collectns;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class Impl {

	public static void main(String[] args) {
		test1();
	}

	private static enum Test {
		VAL1, VAL2, VAL3, VAL4, VAL5;
	}

	/**
	 * Special implementations
	 */
	public static void test1() {

		EnumMap<Test, String> em = new EnumMap<>(Test.class);

		Set<String> s = new HashSet<>();
		Collections.synchronizedCollection(s);
		Collections.synchronizedSet(s);
		Collections.unmodifiableCollection(s);
		Collections.unmodifiableSet(s);
		Collections.emptyMap();

	}

}
