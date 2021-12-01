package com.os.udemy.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class AfterThrowingAspect {
    @AfterThrowing(
            pointcut="execution(* com.os.udemy.spring.aop.dao.AccountDAO.findAccounts(..))",
            throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
                    JoinPoint theJoinPoint, Throwable theExc) {
        
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        
        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    
    }
}
