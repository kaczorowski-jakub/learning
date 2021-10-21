package streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        
    }
    
    public static <T> List<T> flatList(List<List<T>> list) {
        return list.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
