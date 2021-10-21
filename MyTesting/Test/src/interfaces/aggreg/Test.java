package interfaces.aggreg;

import java.util.LinkedList;
import java.util.List;

public class Test {

	private int a = 0;

	public Test inc(int b) {

		this.a += b;
		return this;
	}

	public Test red(int b) {

		this.a -= b;
		return this;
	}

	public Test mul(int b) {

		this.a *= b;
		return this;
	}

	public void print() {

		System.out.println(a);
	}

	public static void main(String[] args) {
		
		Test t = new Test();
		
		t.inc(34).red(31).mul(5).print();
		
		List<String> list = new LinkedList<>();
		list.add("ala");
		list.add("ma");
		list.add("TEST123");
		list.add("oraz");
		list.add("43TEST232");
		list.stream().filter((a) -> {return ((String) a).contains("TEST");}).forEach((a) -> System.out.println(a));
		
	}

}
