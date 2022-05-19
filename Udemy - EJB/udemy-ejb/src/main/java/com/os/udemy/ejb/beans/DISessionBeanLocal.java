package com.os.udemy.ejb.beans;

import javax.ejb.Local;

@Local
public interface DISessionBeanLocal {
    void sessionMethod(String a, Integer b);
}
