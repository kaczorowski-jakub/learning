package com.os.udemy.generics.mine;

public class Main {
    public static void main(String[] args) {
        FirstClass<Number> firstClass = new FirstClass<>();
        SecondClass<Integer> secondClass = new SecondClass<>();
        
        //firstClass = secondClass; //Type mismatch: cannot convert from SecondClass<Integer> to FirstClass<Number>
    }
}
