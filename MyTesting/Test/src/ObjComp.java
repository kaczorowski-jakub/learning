
public class ObjComp {
	
	
	String a;
	CB cb;
	
	public static void main(String[] args) {
		
		ObjComp o1 = new ObjComp();
		o1.a = "AAA";
		o1.cb = new CB();
		
		ObjComp o2 = new ObjComp();
		o2.a = "AAA";
		o2.cb = new CB();
		
		ObjComp o3 = new ObjComp();
		o3.a = o1.a;
		o3.cb = o1.cb;
		
		ObjComp o4 = new ObjComp();
		ObjComp o5 = o4;
		
		System.out.println("o1 == o2 -> " + (o1==o2));
		System.out.println("o1 == o3 -> " + (o1==o3));
		System.out.println("o4 == o5 -> " + (o4==o5));
		System.out.println("o1.equals(o2) -> " + o1.equals(o2));
		System.out.println("o1.equals(o3) -> " + o1.equals(o3));
		System.out.println("o5.equals(o4) -> " + o5.equals(o4));
		
		
		ObjComp oo = new ObjComp();
		TTT t1 = oo.new TTT();
		TTT t2 = oo.new TTT();
		
		t1.a = 12;
		t2.a = t1.a;
		
		System.out.println("t1.equals(t2) -> " + t1.equals(t2));
		
		ABC abc = new ABC();
	}
	
	private class TTT {
		
		int a;
		
	}
	
	private static class ABC {
		
		int b;
		
	}
}
