package com.os.udemy.generics;

public class TypeErasureBridgeMethod {

}

class Node<T> {
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }

    @Override
    public void setData(Integer data) {
        super.setData(data);
    }
}

/*
 after type erasuer
 
 class Node {
    private Object data;

    public Node(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

class MyNode extends Node {
    public MyNode(Integer data) {
        super(data);
    }

    @Override   !!!! - here we have a problem because the parameters do not match with
                       the super class
    public void setData(Integer data) {
        super.setData(data);
    }
    
    !!! so we will have a bridge method
    public void setData(Object o) {
        setData((Integer) o);
}
*/
