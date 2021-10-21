package misc;

import java.util.HashSet;
import java.util.Set;

public class DoubleBracesTest {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<String>() {
            {
               add("India");
               add("USSR");
               add("USA");
            }
        };
        System.out.println(countries);
    }
}
