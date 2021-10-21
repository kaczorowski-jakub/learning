package streams;

public class ParallelStream {
    public static void main(String[] args) {
        
        // sequential stream
        System.out.println("-----SEQUENTIAL-----");
        BoardGame.inMemoryExample().stream().forEach(System.out::println);
        
        // parallel stream
        System.out.println("-----PARALLEL-----");
        BoardGame.inMemoryExample().parallelStream().forEach(System.out::println);
        BoardGame.inMemoryExample().stream().parallel().forEach(System.out::println);
    }
}
