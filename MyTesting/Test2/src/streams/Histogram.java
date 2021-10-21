package streams;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Histogram {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,3,3,3,2,2,1);
        stream.collect(Collectors.groupingBy(Function.identity())).forEach((a,b) -> System.out.println(a + " -> " + b.size()));
    }
}
