package com.os.udemy.ejb.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.os.udemy.ejb.interceptor.InterceptorClass;

/**
 * Session Bean implementation class InterceptorBean
 */
@Interceptors({InterceptorClass.class})
@Stateless(mappedName = "bean/interceptorBean")
@LocalBean
public class InterceptorBean implements InterceptorBeanRemote {

    /**
     * Default constructor. 
     */
    public InterceptorBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void met1(String a) {
        System.out.println("I'm in method met1: " + a);
        
    }

    @Override
    public void met2() {
        System.out.println("I'm in method met2");
    }

}
