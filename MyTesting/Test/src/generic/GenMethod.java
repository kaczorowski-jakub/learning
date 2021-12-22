package generic;

import java.util.List;

public class GenMethod {

	public static <K, V> boolean getValue(K k, V v) {

		return true;
	}

	public <K, V> boolean getValue2(K k, V v) {
		return false;
	}

	public <K, V> void getValue3(InterImpl<K, V> a) {

	}

	public void getValue4(InterImpl<?, ?> a) {

		GenMethod.<String, Integer> getValue("DSADA", 12);
		this.<String, Integer> getValue2("SDAS", 1);
		GenMethod.getValue("ALA", "KOAT");

	}
	
	public void getValue5(List<Number> l) {
		
	}
	
	public static <K, V> V getByKey(K key, V val) {
	    if (key != null) {
	        return val;
	    } else {
	        return null;
	    }
	}
	
}
