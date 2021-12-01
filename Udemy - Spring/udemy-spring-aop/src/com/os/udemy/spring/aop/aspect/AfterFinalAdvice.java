package com.os.udemy.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinalAdvice {

    @After("execution(* com.os.udemy.spring.aop.dao.AccountDAO.findAccounts2(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " 
                            + method);
    
    }
    
}
