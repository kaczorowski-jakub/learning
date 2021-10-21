package streams;

import java.util.ArrayList;
import java.util.List;

/**
 * we can't change the source of data
 * 
 * @author jakub.kaczorowski
 *
 */
public class ImmutableSourceRule {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        numbers.stream().map(v -> numbers.add(v) ? 1 : 0).forEach(System.out::println);
    }
}
