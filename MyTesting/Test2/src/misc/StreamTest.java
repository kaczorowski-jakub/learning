package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream s = init().stream();
        System.out.println(s.findAny());
        System.out.println(s.findFirst());
    }
    
    private static List<String> init() {
        List<String> list = new ArrayList<String>() {
            private static final long serialVersionUID = 7731529071259319926L;

            {
                add("TEST");
                add("TEST2");
            }
        };
        return list;
    }
}
