package com.os.udemy.collections.map;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Person p = (Person) obj;
        if (age != p.age) {
            return false;
        }
        if (name == null) {
            if (p.name != null) {
                return false;
            }
        } else if (!name.equals(p.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " is at age of " + age;
    }

}
