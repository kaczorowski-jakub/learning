package lambdaexpression;

import java.util.TreeSet;
import java.util.function.Function;

public class LambdaFunctionTest {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>((a,b) -> -1);
        Function<String, Integer> fun1 = a -> 1;
        Function<String, Integer> fun2 = (String a) -> 1;
        Function<String, Integer> fun3 = (String a) -> {return 1;};
        Function<String, Integer> fun4 = new Function<>() {

            @Override
            public Integer apply(String t) {
                // TODO Auto-generated method stub
                return null;
            }
            
        };
    }
}
