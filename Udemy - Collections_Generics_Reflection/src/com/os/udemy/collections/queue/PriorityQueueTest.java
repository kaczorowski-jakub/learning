package com.os.udemy.collections.queue;

import java.util.PriorityQueue;

/**
 * based on HEAP
 * 
 * each element has a priority and they are ordered by the priority or their
 * natural order
 * 
 * elements with highest priority are served first
 * 
 * @author jakub.kaczorowski
 *
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>((p1, p2) -> {
            return p1.getAge() - p2.getAge();
        });
        queue.add(new Person("Kevin", 22));
        queue.add(new Person("Joe", 37));
        queue.add(new Person("Adam", 12));
        queue.add(new Person("Anna", 45));
        System.out.println(queue);
        
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + " age of " + getAge();
    }

}
