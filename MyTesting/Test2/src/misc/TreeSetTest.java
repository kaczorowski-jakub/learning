package misc;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Obj> tree = new TreeSet<>((a,b) -> a.getVal().compareTo(b.getVal()));
        tree.add(new Obj("99"));
        tree.add(new Obj("12"));
        tree.add(new Obj("59"));
        //tree.add(null);//null pointer here
        
        tree.forEach(v -> System.out.println(v.getVal()));
        
        Iterator<Obj> i = tree.iterator();
        tree.add(new Obj("45"));
        while (i.hasNext()) {
            System.out.println(i.next().getVal());
        }
        
    }
    
    private static class Obj {
        private final String val;
        
        private Obj(String val) {
            this.val = val;
        }
        
        private String getVal() {
            return val;
        }
    }
}
