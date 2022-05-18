package com.os.udemy.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorClass {
    
    @AroundInvoke
    public Object methodInterceptorAround(InvocationContext context) throws Exception {
        System.out.println("methodInterceptorAround: " + context.getMethod().getName());
        return context.proceed();
    }
    
}
