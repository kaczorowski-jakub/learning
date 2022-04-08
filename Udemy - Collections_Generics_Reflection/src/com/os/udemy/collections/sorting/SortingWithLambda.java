package com.os.udemy.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWithLambda {
    
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        
        people.add(new Person("Adam", 33));
        people.add(new Person("Joe", 12));
        people.add(new Person("Michael", 25));
        people.add(new Person("Ana", 27));
        people.add(new Person("Katy", 78));
        people.add(new Person("Katy", 6));
        people.add(new Person("Kevin", 45));
        
        System.out.println("Original: " + people);
        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("By Name: " + people);
        Collections.sort(people, Comparator.comparing(Person::getAge));
        System.out.println("By age: " + people);
        Collections.sort(people, Comparator.comparing(Person::getAge).reversed());
        System.out.println("By age reversed: " + people);
        Collections.sort(people, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println("By name and age: " + people);
    }
    
    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
    }
}
