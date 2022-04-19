package com.os.udemy.reflection;

public class Person {
    private String name;
    private int age;
    public String publicField;
    protected String protField;
    String defaultField;
    private static String privateField;
    
    @MyAnnot(name="1234")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getProtField() {
        return protField;
    }

    public void setProtField(String protField) {
        this.protField = protField;
    }

    public String getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }

    private String[] privateMethods() {
        return null;
    }

    void defaultMethod() {

    }

    protected void protectedMethod() {

    }
}

class Employee extends Person implements Cloneable, Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}