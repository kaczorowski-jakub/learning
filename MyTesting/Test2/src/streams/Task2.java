package streams;

public class Task2 {
    public static void main(String[] args) {
        
        System.out.println(BoardGame.inMemoryExample().stream().reduce(null, (partial, bg) -> {
            if (partial == null) {
                return bg;
            } else {
                return partial.rating < bg.rating ? partial : bg;
            }
        }).name);
        
    }
}
