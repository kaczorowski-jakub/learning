package com.os.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }

    @Before("execution(* add*())")
    public void beforeAddAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on add method");

    }
    
    @Before("execution(* com.os.udemy.spring.aop.dao.pkg1.*.*(..))")
    public void beforeAnyMethodInPackageAdvice() {
        
        System.out.println("\n=====>>> Executing @Before advice on any method in package 1");
        
    }
    
    @Before("execution(* add*(..))")
    public void beforeAddMethodWithAnyParamsAdvice() {
        
        System.out.println("\n=====>>> Executing @Before advice on add* method with any params");
        
    }

}
