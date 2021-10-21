package streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReduceStram {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() {
            {
                add(1);
                add(65);
                add(101);
                add(1001);
                add(987);
            }
        };

        System.out.println(list.stream().reduce((partial, element) -> partial + element).get());
        System.out.println(list.stream().reduce(100, (partial, element) -> partial + element));
        
        System.out.println(BoardGame.inMemoryExample().stream().reduce((partial, element) -> element.maxPlayers > partial.maxPlayers ? element : partial).get());
        System.out.println(BoardGame.inMemoryExample().stream().reduce(new BigDecimal(0), (partial, element) -> partial.add(element.price), (a,b) -> a.add(b)));
    }

}
