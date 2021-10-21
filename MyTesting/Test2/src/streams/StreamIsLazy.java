package streams;

import java.util.stream.IntStream;

/**
 * Streams are lazy - they start processing when they reach terminated method
 * @author jakub.kaczorowski
 *
 */
public class StreamIsLazy {
    public static void main(String[] args) {
        IntStream numbersStream = IntStream.range(0, 8);
        System.out.println("Przed");
        numbersStream = numbersStream.filter(n -> n % 2 == 0);
        System.out.println("W trakcie 1");
        numbersStream = numbersStream.map(n -> {
            System.out.println("> " + n);
            return n;
        });
        System.out.println("W trakcie 2");
        numbersStream = numbersStream.limit(3);
        System.out.println("W trakcie 3");
        numbersStream.forEach(System.out::println);
        System.out.println("Po");
        
        IntStream.range(0, 8).filter(n -> n % 2 == 0).map(n -> {
            System.out.println("> " + n);
            return n;
        }).limit(3)
        .forEach(System.out::println);

    }
}
