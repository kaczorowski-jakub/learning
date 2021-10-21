package concurency;

final public class Immutable {

	private final String a;

	public Immutable(String a) {
		this.a = a;
		
		new Thread(() -> {
		    
		}); 
	}

	public String getA() {
		
		try {
			int[] a = new int[12];
			a[44] = 32;
		} finally {
			
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		
		Immutable i = new Immutable("A");
		i.getA();
		
	}
	
}
