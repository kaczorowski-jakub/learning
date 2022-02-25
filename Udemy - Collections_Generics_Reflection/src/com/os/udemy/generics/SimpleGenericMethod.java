package com.os.udemy.generics;

public class SimpleGenericMethod {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        
        gm.showItem("Hello world");
        gm.showItem(43);
        gm.showItem('a');
        
        System.out.println("returned: " + gm.showItem2('a'));
        System.out.println("returned: " + gm.showItem2(3232));
        
        gm.showItem("Adam", 98);
        
        gm.showItems(new String[] {"Ala", "ma", "kota"});
        //gm.showItems(new int[] {1,2,3,4}); //The method showItems(T[]) in the type GenericMethod is not applicable for the arguments (int[])
        gm.showItems(new Integer[] {1,2,3,4});
    }
}

class GenericMethod {
    
    public <T> void showItem(T t) {
        System.out.println("The item is " + t.toString());
    }
    
    public <T> T showItem2(T t) {
        System.out.println("The item is " + t.toString());
        return t;
    }
    
    public <T, V> void showItem(T t, V v) {
        System.out.println(t +" - " + v);
    }
    
    public <T> void showItems(T[] items) {
        for (T t: items) {
            System.out.println(t);
        }
    }
}
