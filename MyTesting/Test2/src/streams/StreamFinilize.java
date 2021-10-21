package streams;

public class StreamFinilize {
    public static void main(String[] args) {
        
        // for each
        System.out.println("-----FOR EACH-----");
        BoardGame.inMemoryExample().stream().forEach(System.out::println);
        
        // all match
        System.out.println("-----ALL MATCH-----");
        System.out.println(BoardGame.inMemoryExample().stream().allMatch(bg -> bg.rating > 1));
        
        // MAX
        System.out.println("-----MAX-----");
        System.out.println(BoardGame.inMemoryExample().stream().max((bg1,bg2) -> (int) (bg1.rating - bg2.rating)));
    }
}
