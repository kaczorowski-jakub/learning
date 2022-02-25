package com.os.udemy.generics;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jakub.kaczorowski
 *
 */
public class TypeErasure {
    public static void main(String[] args) {

        // example 1 - nice question for the interviews: what is faster generic or
        // non-generic?
        // - the same speed due to type erasure
        // - but when using generic we get compilation time exception instead of
        // runtime exception
        List<Integer> list = new ArrayList<>();
        list.add(4);
        Integer a = list.get(0);
        // will be transformed to
        List list2 = new ArrayList<>();
        list2.add(4);
        Integer b = (Integer) list2.get(0);

        // example 2
        FirstStoreGeneric<String> store = new FirstStoreGeneric<>();
        // compilation type checking
        store.setItem("DASDA");
        store.getItem();
        // store.setItem(123);//The method setItem(String) in the type
        // FirstStoreGeneric<String> is not applicable for the arguments (int)

        FirstStoreResult firstStoreResult = new FirstStoreResult();
        firstStoreResult.setItem("ASDSA");
        firstStoreResult.setItem(123);
        
        SecondStoreGeneric secondStoreGeneric = new SecondStoreGeneric();
        

    }
}

// generic
class FirstStoreGeneric<T> {
    private T item;

    {
        try {
            for (Field field : FirstStoreGeneric.class.getDeclaredFields()) {
                System.out.println(field.getName() + ", " + field.getType());
            }
        } catch (Exception e) {

        }
    }

    public T getItem() {
        System.out.println(item.getClass());
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// result
class FirstStoreResult {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

//generic
class SecondStoreGeneric<T extends Serializable> {
    private T item;

    {
        try {
            for (Field field : SecondStoreGeneric.class.getDeclaredFields()) {
                System.out.println(field.getName() + ", " + field.getType());
            }
        } catch (Exception e) {

        }
    }

    public T getItem() {
        System.out.println(item.getClass());
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}