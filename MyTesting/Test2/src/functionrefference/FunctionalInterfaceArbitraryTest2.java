package functionrefference;

@FunctionalInterface
public interface FunctionalInterfaceArbitraryTest2 {
    public String print(Person s);
}

interface FunctionalInterfaceArbitraryTest3 {
    public String print(Person s, int agePlus);
}

interface FunctionalInterfaceArbitraryTest4 {
    public Person print();
}

interface FunctionalInterfaceArbitraryTest5 {
    public Person print(String name, int age);
}

interface FunctionalInterfaceArbitraryTest6 {
    public Person print(String name);
}

class Person {
    String name;
    int age;
    
    public Person() {
        this("A",1);
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
    
    public String toStringPlus(int agePlus) {
        return name + "(" + (age + agePlus) + ")";
    }
}