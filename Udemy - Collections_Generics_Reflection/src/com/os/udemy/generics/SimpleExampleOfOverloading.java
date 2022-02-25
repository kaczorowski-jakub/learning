package com.os.udemy.generics;

public class SimpleExampleOfOverloading {
    
    private static void add(int a, int b) {
        int result = a + b;
        System.out.println("Result: " + result);
    }
    
    private static void add(double a, double b) {
        double result = a + b;
        System.out.println("Result: " + result);
    }
    
    
    public static void main(String[] args) {
        add(1,2);
        add(1.2,2.3);
    }
}
