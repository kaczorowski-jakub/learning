package com.os.udemy.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface BeanManagedBeanRemote {
    
    void testNever() throws Exception;
    void testMandatory() throws Exception;
}
