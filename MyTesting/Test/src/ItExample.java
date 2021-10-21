import java.util.Iterator;

public class ItExample implements Iterable<String> {

	private String a;
	private String b;
	private ItImpl itImpl;

	public ItExample() {
		a = "A";
		b = "B";
		itImpl = new ItImpl();
	}

	public static void main(String[] args) {
		
		ItExample it = new ItExample();
		for (String i : it) {
			System.out.println(i);
		}
		
	}

	private class ItImpl implements Iterator<String> {
		
		private int cnt = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			cnt++;
			if (cnt < 10) return true; 
			else return false;
		}

		@Override
		public String next() {
			
			if (cnt % 2 == 0) return a;
			else return b;
		}
		
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Override
	public Iterator<String> iterator() {
		return itImpl;
	}

}
