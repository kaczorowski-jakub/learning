package misc;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        Main m = new Main();
        
        Set<Comp> set = new HashSet<>();
        System.out.println(set.add(m.createComp("ALA")));
        System.out.println(set.add(m.createComp("ALA")));
        System.out.println(set.size());
        
        I1 i1 = new C1();
        i1.test2();
        
        I1 i11 = new C2();
        i11.test2();
        
        
    }
    
    public Comp createComp(String val) {
        Comp comp = new Comp();
        comp.setVal(val);
        return comp;
    }

}
