package com.os.udemy.generics;

public class BoundedGenerics {
    public static void main(String[] args) {
        System.out.println('a' + 'b' + 'c');

        System.out.println(calcMin(12, 32));
        System.out.println(calcMin(32, 32));
        System.out.println(calcMin(32, 12));
        System.out.println(calcMin('f', 'a'));
        System.out.println(calcMin("Ana", "Kevin"));
        // System.out.println(calcMin(new Person(), new Person())); //The method
        // calcMin(T, T) in the type BoundedGenerics is not applicable for the arguments
        // (Person, Person)
        System.out.println(calcMin(new PersonComp("Marek"), new PersonComp("Browarek")));
        System.out.println(add(1,2));
        System.out.println(add(1.5f,2));
        System.out.println(add(0b01110,0b10001));
        System.out.println(add((byte)0b01110,0b10001));
        System.out.println(add((short)0b01110,0b10001));
    }

    public static <T extends Comparable<T>> T calcMin(T number1, T number2) {
        return number1.compareTo(number2) < 0 ? number1 : number2;
    }
    
    public static <T extends Number> double add(T number1, T number2) {
        double result = number1.doubleValue() + number2.doubleValue();
        return result;
    }
    
}

class Person {

}

class PersonComp implements Comparable<PersonComp> {
    private final String name;

    public PersonComp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name is: " + name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(PersonComp o) {
        if (o == null) {
            return -1;
        }
        return this.name.compareTo(o.getName());
    }

}
