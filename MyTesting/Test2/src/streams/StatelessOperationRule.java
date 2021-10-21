package streams;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * stream method cannot have state - can't be like below where
 * modify method uses seen hashset to store a state
 * @author jakub.kaczorowski
 *
 */
public class StatelessOperationRule {
    private final Set<Integer> seen = new HashSet<>();

    private int modify(int number) {
        if (seen.contains(number)) {
            return number;
        }
        seen.add(number);
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Stream<Integer> numbers = Stream.of(1, 2, 3, 1, 2, 3, 1, 2, 3);
            StatelessOperationRule requriements = new StatelessOperationRule();
            int sum = numbers.parallel()
                    .map(requriements::modify)
                    .mapToInt(n -> n.intValue())
                    .sum();
            System.out.println(sum);
        }
    }
}
