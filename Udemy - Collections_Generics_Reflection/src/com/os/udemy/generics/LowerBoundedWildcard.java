package com.os.udemy.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * in lower bounded wildcards we are able to manipulate but we are not able to
 * read because while reading we are not sure what we get List<? super Integer>
 * can have Object, Number, Integer
 * 
 * @author jakub.kaczorowski
 *
 */
public class LowerBoundedWildcard {
    public static void main(String[] args) {
        List<? super Integer> list1 = new ArrayList<Integer>();
        List<? super Integer> list2 = new ArrayList<Number>();
        List<? super Integer> list3 = new ArrayList<Object>();
        showAllInt(list1);
        showAllInt(list2);
        showAllInt(list3);

        // reading and adding
        List<Serializable> list4 = new ArrayList<>();
        list4.add("Adam"); // OK because String implements Serializable
        list4.add("Ana");
        list4.add("Kevin");
        list4.add(1); // OK because Integer implements Serializable
        list4.add(2);
        showAll(list4); // Serializable is implemented by Number so it's OK
        // showAll(list1); // not OK because List<? super Integer> does not fit ? super
        // Number
        addItem(list4); // OK because Serializable is implemented by Number
        // addItem(list1); // not OK because Integer is a subtype of Number

        List<? super Number> list5 = new ArrayList<>();
        list5.add(54);
        // list5.add("ADASD"); // The method add(capture#5-of ? super Number) in the
        // type List<capture#5-of ? super Number> is not applicable for the arguments
        // (String)

        List<? extends Number> list6 = new ArrayList<>();
        list5.add(54);
        //list5.add("ADSADAS"); // The method add(capture#6-of ? super Number) in the type List<capture#6-of ?
                              // super Number> is not applicable for the arguments (String)
    }

    private static void addItem(List<? super Number> list) {
        list.add(45); // OK because Integer extends from Number
        // list.add("ALA MA KOTA"); // not OK because String does not inherit from
        // Number
    }

    private static void showAll(List<? super Number> list) {

        // Type mismatch: cannot convert from element type capture#1-of ? super
        // Number
        // to Number
//        for (Number n : list) {
//            System.out.println(n);
//        }

        // we must go with Object
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void showAllInt(List<? super Integer> list) {

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
