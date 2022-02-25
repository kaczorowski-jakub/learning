package com.os.udemy.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardSimple {
    public static void main(String[] args) {

        // Type mismatch: cannot convert from ArrayList<Integer> to ArrayList<Number>
        // ArrayList<Integer> is a subtype of List<Number>
        // List<Number> list = new ArrayList<Integer>();

        // ArrayList<Integer> is a subtype of List<?>
        List<?> list1 = Arrays.asList(12, 3, 43);

        // we can print
        for (Object o : list1) {
            System.out.println(o);
        }
        System.out.println(list1);

        // but we cannot add
        // list1.add(32);//The method add(int, capture#3-of ?) in the type
        // List<capture#3-of ?> is not applicable for the arguments (int)

        ArrayList<?> list2 = new ArrayList<Integer>();
        System.out.println(list2);

        // -------------------------------------

        Integer i = 23;
        print(i);

        List<Integer> list3 = Arrays.asList(1, 2, 3);
        // print2(list3); //The method print2(List<Object>) in the type WildcardSimple
        // is not applicable for the arguments (List<Integer>)

        // -------------------------------------
        List<Shape> list4 = new ArrayList<>();
        list4.add(new Rectangle());
        list4.add(new Circle());
        drawAll(list4);

        List<Rectangle> list5 = Arrays.asList(new Rectangle(), new Rectangle());
        // The method drawAll(List<Shape>) in the type WildcardSimple is not applicable
        // for the arguments (List<Rectangle>)
        // drawAll(list4);
        drawAll2(list5);
        drawAll3(list5);
        drawAll4(list5);
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }

    public static void print2(List<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void drawAll(List<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    // wildcard without boundry approach - casting needed
    public static void drawAll2(List<?> shapes) {
        // Type mismatch: cannot convert from element type capture#4-of ? to Shape
        /*
         * for (Shape shape : shapes) { shape.draw(); }
         */
        for (Object o : shapes) {
            ((Shape) o).draw();
        }
    }

    // wildcard with boundry approach - no casting needed
    public static void drawAll3(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }

    // bounded type approach - no casting needed
    public static <T extends Shape> void drawAll4(List<T> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle on the canvas...");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle on the canvas...");
    }
}