package streams;

import java.util.stream.Collectors;

public class StreamOperation {
    public static void main(String[] args) {
        
        // map
        System.out.println("-----MAP-----");
        BoardGame.inMemoryExample().stream().mapToDouble(BoardGame::getRating).forEach(System.out::println);
        
        // filter
        System.out.println("-----FILTER-----");
        BoardGame.inMemoryExample().stream().filter(bg -> bg.getRating() > 8).forEach(System.out::println);
        
        // peek
        System.out.println("-----PEEK-----");
        BoardGame.inMemoryExample().stream().peek(bg -> bg.tmpName = "TEST").forEach(System.out::println);
        
        // groupingBy
        BoardGame.inMemoryExample().stream()
        .collect(Collectors.groupingBy(game -> game.getRating()))
        .forEach((a,b) -> System.out.println(a + " -> " + b));
    }
}
