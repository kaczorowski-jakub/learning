package com.os.udemy.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface TestSessionBeanRemote {
    
    void sayHi(String name);
    
    void createTimer(long milseconds);
    
    void diMethod();
}
