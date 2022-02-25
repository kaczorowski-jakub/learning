package com.os.udemy.generics.mine;

public class SecondClass<T> extends FirstClass<T>{
    private T itemInner;
    
    public T getItemInner() {
        return itemInner;
    }
    
    public void setItemInner(T itemInner) {
        this.itemInner = itemInner;
    }
}
