package com.os.udemy.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeInferenceSimple {

    public static void main(String[] args) {

        // we do not have to specify the types because compiler will do it for us
        // the T will be Serializable
        Serializable c = getData("TEST", new ArrayList<Number>());
        System.out.println(c);

        List<String> list = new ArrayList<>(); // <> is also inference because compiler will know the type - String
        System.out.println(list);

        List<Bucket<String>> list2 = new ArrayList<>();
        addStore("Adam", list2); // type inference here
        TypeInferenceSimple.<String>addStore("Bronek", list2); // alternativly we can have the declaration - type
                                                               // witness
        
        List<Integer> list1 = add(new ArrayList<>(), 20, 30);
        System.out.println(list1);
        
        //List<String> list3 = add(new ArrayList<>(), 20, 30);    //Type mismatch: cannot convert from List<Integer> to List<String>
    }

    static <T> List<T> add(List<T> list, T item1, T item2) {
        list.add(item1);
        list.add(item2);
        return list;
    }

    public static <T> T getData(T t1, T t2) {
        return t1;
    }

    public static <T> void addStore(T t, List<Bucket<T>> list) {
        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list...");
    }
}

class Bucket<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
