package com.os.udemy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        className();
        System.out.println("---");
        classFields();
        System.out.println("---");
        methods();
        System.out.println("---");
        constructor();
        System.out.println("---");
        superClassAndInheritance();
        System.out.println("---");
        annotationReader();
    }
    
    public static void annotationReader() {
        Class<Person> p = Person.class;
        for (Method m : p.getMethods()) {
            if (m.isAnnotationPresent(MyAnnot.class)) {
                System.out.println(m.getName());
            }
        }
    }
    
    public static void superClassAndInheritance() {
        Class<Employee> clazz = Employee.class;
        System.out.println(clazz.getSuperclass());
        for (Class<?> c : clazz.getInterfaces()) {
            System.out.println(c.getName());
        }
    }
    
    public static void constructor() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<ConstructorTestPublic> constructor = ConstructorTestPublic.class.getDeclaredConstructor();
        ConstructorTestPublic t = constructor.newInstance();
        System.out.println(t.getVal());
        
        Constructor<ConstructorTestSingleton> constructor2 = ConstructorTestSingleton.class.getDeclaredConstructor();
        constructor2.setAccessible(true);
        ConstructorTestSingleton t2 = constructor2.newInstance();
        System.out.println(t2.getVal());
    }

    public static void methods() {
        Class<Person> p = Person.class;

        // public _ inherited
        System.out.print("methods: ");
        for (Method m : p.getMethods()) {
            System.out.print(m.getName() + "(ret: " + m.getReturnType() + "),");
        }
        System.out.println("");

        // all without inherited
        System.out.print("declared methods: ");
        for (Method m : p.getDeclaredMethods()) {
            System.out.print(m.getName() + "(ret: " + m.getReturnType() + "),");
        }
        System.out.println("");
    }

    public static void classFields() {
        Class<Person> p = Person.class;
        System.out.println(p.getName());
        System.out.println(p.getPackage());

        // only public
        System.out.print("fields: ");
        for (Field f : p.getFields()) {
            System.out.print(f.getName() + ",");
        }
        System.out.println("");

        // all the fields
        System.out.print("declared fields:");
        for (Field f : p.getDeclaredFields()) {
            System.out.print(f.getName() + ",");
        }
        System.out.println("");
    }

    public static void className() throws ClassNotFoundException {
        // class name
        Class<Person> clazz = Person.class;
        System.out.println(clazz.getName());

        Class<?> personClass = null;
        personClass = Class.forName("com.os.udemy.reflection.Person");
        System.out.println(personClass.getName());

        checkClass(new Bus());
        checkClass(new Car());
    }

    public static void checkClass(Vehicle vehicle) {
        Class<?> c = vehicle.getClass();
        System.out.println(c.getName());
    }
}
