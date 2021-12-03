package devskiller;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();
        for (int i = 0; i < 10_000; ++i) {
            map.put(new Key(i), "SomeValue" + i);
        }
        map.get(new Key(9999));
        System.out.println(map.size());
    }
}
