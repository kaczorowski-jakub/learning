package com.os.udemy.generics.mine;

public class FirstClass <T> {
    private T itemOutter;
    
    public T getItemOutter() {
        return itemOutter;
    }
    
    public void setItemOutter(T itemOutter) {
        this.itemOutter = itemOutter;
    }
}
