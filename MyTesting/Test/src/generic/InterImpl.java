package generic;

public class InterImpl<K,V> implements Inter<K, V> {
	
	V v;
	
	public void add(K k, V v) {}
	
	public V get(K k) {return v;}
	
}
