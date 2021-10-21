package com.os.udemy.jpa;

import java.util.function.Function;

public class Something {
    
    public static void main(String[] args) {
        Something s = new Something();
        Function<Integer, Integer> function = s::cal;
        System.out.println(function.apply(12));
        
        
    }
    
    public int cal(int a) {
        return a + 2;
    }
}
