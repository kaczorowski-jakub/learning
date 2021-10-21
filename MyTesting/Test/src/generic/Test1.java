package generic;

public class Test1 {

	public <K> void replace(K[] k, int idx1, int idx2) {
		K o1 = k[idx1];
		K o2 = k[idx2];
		k[idx1] = o2;
		double f = 12.23;
		Boolean b = true;
		Integer ab = 12;
		k[idx2] = o1;
	}
	
}
