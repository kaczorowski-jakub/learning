package com.os.udemy.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * in upper bounded we are able to read but we are not able to manipulate
 * because the type cannot be guaranteed, e.g. List<? extends Number> can have
 * Integer, Float, Double so when we add we don't know the type which is already
 * there but when we READ we are sure we get Number
 * 
 * @author jakub.kaczorowski
 *
 */
public class UpperBoundedWildcard {
    public static void main(String[] args) {
        List<? extends Number> list01 = new ArrayList<Number>();
        List<? extends Number> list02 = new ArrayList<Integer>();
        List<? extends Number> list03 = new ArrayList<Float>();
        // List<? extends Number> list04 = new ArrayList<Object>(); //Type mismatch:
        // cannot convert from ArrayList<Object> to List<? extends Number>

        // we can accept any class of subtype of Number: Integer, Double etc. including
        // Number
        List<? extends Number> list1 = new ArrayList<>();
        // list1.add(23); // The method add(int, capture#1-of ? extends Number) in the
        // type
        // List<capture#1-of ? extends Number> is not applicable for the arguments (int)

        List<? extends Number> list2 = new ArrayList<Integer>();
        // list2.add(43); //The method add(int, capture#1-of ? extends Number) in the
        // type List<capture#1-of ? extends Number> is not applicable for the arguments
        // (int)

        List<? extends Integer> list3 = Arrays.asList(1, 2, 3, 4);
        showAll(list3);

        List<? extends Integer> list4 = Arrays.asList(1, 2, 3, 4);
        showAll(list4);
    }

    private static void showAll(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }
}
