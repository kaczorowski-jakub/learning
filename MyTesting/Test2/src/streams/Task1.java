package streams;

public class Task1 {
    public static void main(String[] args) {
        methodBeforeTransformation();
        methodAfterTransformation();
    }

    public static void methodBeforeTransformation() {
        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.inMemoryExample()) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        System.out.println(bestGame.name);
    }
    
    public static void methodAfterTransformation() {
        System.out.println(BoardGame.inMemoryExample().stream()
            .filter(bg -> bg.name.contains("a"))
            .max((bg1, bg2) -> (int)(bg1.rating - bg2.rating)).get().name);
    }
}
