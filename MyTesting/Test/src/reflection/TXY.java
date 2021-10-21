package reflection;

import static java.lang.System.out;

public class TXY {

	
	public TXY() {
		out.println("TXY - constructor empty");
	}
	
	public TXY(int a){
		this();
		out.println("TXY - constructor one");
	}
	
	static {
		out.println("TXY - static");
	}
	
	{
		out.println("TXY - normal");
	}
}
