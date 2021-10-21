package streams;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class OpenClose {
    public static void main(String[] args) {
        
        // terminal operation - doesn't create a new stream
        System.out.println("#1");
        Stream<BoardGame> stream1 = BoardGame.inMemoryExample().stream();
        stream1.onClose(OpenClose::onClose);
        out.println(stream1.count());
        try {
            out.println(stream1.findAny());
        } catch (IllegalStateException e) {
            System.out.println("stream already closed");
        }
        
        // each operation creates a new stream
        System.out.println("#2");
        Stream<BoardGame> stream2 = BoardGame.inMemoryExample().stream();
        stream2.filter(bg -> bg.rating > 4.0);
        try {
            stream2.filter(bg -> bg.price.compareTo(new BigDecimal(150)) > 0);
        } catch(IllegalStateException e) {
            System.out.println("stream already closed");
        }
        
        // combining operations
        System.out.println("#3");
        Stream<BoardGame> stream3 = BoardGame.inMemoryExample().stream();
        stream3.filter(bg -> bg.rating > 4.0)
               .filter(bg -> bg.price.compareTo(new BigDecimal(150)) > 0)
               .forEach(bg -> System.out.println(bg.toString()));
        
    }
    
    private static void onClose() {
        out.println("Closed");
    }
    
}
