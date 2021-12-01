package com.os.udemy.spring.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AroundAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());
    
    @Around("execution(* com.os.udemy.spring.aop.service.*.getFortune(..))")   
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        
        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);
        
        // get begin timestamp
        long begin = System.currentTimeMillis();
        
        // now, let's execute the method
        Object result = null;
        
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            myLogger.warning(e.getMessage());

            // rethrow exception
            throw e;
        }
        
        // get end timestamp
        long end = System.currentTimeMillis();
        
        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
        
        return result;
    }
    
}
