package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> listU = Collections.unmodifiableList(list);
        list.add("A");
        try {
            listU.add("A");
        } catch(UnsupportedOperationException e) {
            e.printStackTrace();
        }
        
        List<String> listU2 = Collections.EMPTY_LIST;
        try {
            listU2.add("A");
        } catch(UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
}
