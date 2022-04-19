package com.os.udemy.ejb.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestSessionBean
 */
@Stateless(mappedName = "bean/testMappingBean")
@LocalBean
public class TestSessionBean implements TestSessionBeanRemote {

    /**
     * Default constructor. 
     */
    public TestSessionBean() {
        // TODO Auto-generated constructor stub
    }

}
