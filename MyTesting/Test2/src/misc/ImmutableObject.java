package misc;

import java.util.HashSet;
import java.util.Set;

public class ImmutableObject {
    
    private final String name;
    private final Set<Order> set;
    
    public ImmutableObject(String name, Set<Order> set) {
        this.name = name;
        this.set = new HashSet<>(set);  // copy of set
    }
    
    public String getName() {
        return name;
    }
    
    public Set<Order> getSet() {
        return new HashSet<>(set);
    }
    
    public void printSet() {
        set.forEach(o -> System.out.println(o));
    }
    
    public static void main(String[] args) {
        Set<Order> set = new HashSet<>();
        set.add(new Order("1", 12));
        set.add(new Order("2", 14));
        ImmutableObject o1 = new ImmutableObject("first", set);
        o1.printSet();
        
        set.add(new Order("3",16));
        o1.printSet();
    }
    
}

class Order {
    String id;
    float amount;
    
    public Order(String id, float amount) {
        this.id = id;
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return id + " - " + amount;
    }
}
