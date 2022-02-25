package com.os.udemy.generics;

public class SimpleGenericStore {
    public static void main(String[] args) {
        Store store = new Store();
        store.setItem(45);
        
        // we can cast object into any other object
        int item = (int) store.getItem();
        System.out.println(item);
        
        store.setItem(12.32);
        //item = (int) store.getItem(); //java.lang.ClassCastException
        
        // raw type
        StoreGeneric storeGenericRaw = new StoreGeneric();
        
        // concrete type
        StoreGeneric<String> storeGenericString = new StoreGeneric<>();
        storeGenericString.setItem("Ala ma kota");
        String itemString = storeGenericString.getItem();
        System.out.println(itemString);
        
        HashTable<String, Integer> hashTable = new HashTable<>("Hello", 23);
        System.out.println(hashTable);
        
        HashTable<Integer, Integer> hashTable2 = new HashTable<>(43, 23);
        System.out.println(hashTable2);
        
    }
}

class HashTable<K, V> {
    private K key;
    private V value;
    
    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
        System.out.println("Here comes key as " + key.getClass());
        System.out.println("Here comes value as " + value.getClass());
    }
    
    @Override
    public String toString() {
        return "key: " + key + ", value: " + value;
    }
}

class Store {
    private Object item;
    
    public void setItem(Object obj) {
        this.item = obj;
    }
    
    public Object getItem() {
        return item;
    }
}

class StoreGeneric<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}
