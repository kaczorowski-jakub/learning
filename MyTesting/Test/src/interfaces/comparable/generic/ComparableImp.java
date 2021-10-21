package interfaces.comparable.generic;

public class ComparableImp implements Comparable<ComparableImp>{
	
	public int val;
	
	@Override
	public int compare(ComparableImp t) {
		return this.val - t.val;
	}
	
}
