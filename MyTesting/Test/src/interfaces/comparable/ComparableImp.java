package interfaces.comparable;

public class ComparableImp implements Comparable{
	
	int val;
	
	@Override
	public int compare(Comparable c) {
		ComparableImp ci = (ComparableImp) c;
		
		return this.val - ci.val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return "Klasa ComparableImp: " + val;
	}
	
}
