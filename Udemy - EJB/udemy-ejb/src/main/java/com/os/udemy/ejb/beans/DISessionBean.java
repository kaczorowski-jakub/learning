package com.os.udemy.ejb.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DISessionBean
 */
@Stateless(mappedName = "bean/DIBean")
@LocalBean
public class DISessionBean implements DISessionBeanLocal {

    /**
     * Default constructor. 
     */
    public DISessionBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sessionMethod(String a, Integer b) {
        System.out.println(a + " you have " + b + " tomatos");
    }

}
