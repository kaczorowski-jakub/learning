import java.io.Serializable;

public class SerialClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5492013169758475808L;

	private int val;
	private String str;
	private transient int val2;
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	public void printClass() {
		System.out.println(str + " " + val + " - " + val2);
	}
	
	public int getVal2() {
		return val2;
	}
	
	public void setVal2(int val2) {
		this.val2 = val2;
	}
	
}
