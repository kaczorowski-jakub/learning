package streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        
        // collection based
        Stream<Integer> stream1 = new LinkedList<Integer>().stream();
        
        // array based
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{});
        
        // character chain
        Stream<String> stream3 = Pattern.compile(".").splitAsStream("some longer sentence");
        
        // primitive types
        DoubleStream doubles = DoubleStream.of(1, 2, 3);
        IntStream ints = IntStream.range(0, 123);
        LongStream longs = LongStream.generate(() -> 1L);
        
        // random
        DoubleStream randomDoubles = new Random().doubles();
        IntStream randomInts = new Random().ints();
        LongStream randomLongs = new Random().longs();
        System.out.println(randomLongs.count());
        
        // file
        try (Stream<String> lines = new BufferedReader(new FileReader("file.txt")).lines()) {
            // do something
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
