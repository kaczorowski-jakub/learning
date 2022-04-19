package com.os.udemy.reflection;

public class ConstructorTestSingleton {
    private String val;
    
    private ConstructorTestSingleton() {
        this.val = "Constr NEW - unassigned";
    }
    
    public String getVal() {
        return val;
    }
}
