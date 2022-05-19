package com.os.udemy.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface InterceptorBeanRemote {
    
    void met1(String a);
    void met2();
    
}
