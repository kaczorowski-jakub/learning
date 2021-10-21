package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTest {
    
    public static void main(String[] args) {
        
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.computeIfAbsent("John", s -> s.length());
        nameMap.computeIfAbsent("Barbara", String::length);
        nameMap.computeIfAbsent("Martha", FunctionTest::test);
        System.out.println(nameMap);
        
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        IntFunction<String> f1 = i -> "#" + i + "#";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(quoteIntToString.apply(100));
        System.out.println(f1.apply(50));
        
        BiFunction<String, String, Integer> f2 = (String p1, String p2) -> p1.length() + p2.length();
        System.out.println(f2.apply("Ala", "ma kota"));
        
        Supplier<Integer> f3 = () -> new Random().nextInt();
        System.out.println(f3.get());
        System.out.println(f3.get());
        
        Consumer<String[]> f4 = arr -> {
            for (int i = 0 ; i < arr.length ; i++) {
                System.out.println(arr[i]);
            }
        };
        f4.andThen(f4).accept(new String[] {"Ala", "ma", "kota", ", kot", "ma", "Ale"});
        
        Predicate<String> f5 = val -> "Ola".equals(val);
        Predicate<String> f51 = val -> "Ala".equals(val);
        System.out.println(f5.test("Ala"));
        System.out.println(f5.test("Ola"));
        System.out.println(f5.and(f51).test("Ola"));
        System.out.println(f5.or(f51).test("Ola"));
    }
    
    public static int test(String val) {
        return 12 + val.length();
    }
}
