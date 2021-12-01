package com.os.udemy.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.os.udemy.spring.aop.dao.pkg1.AccountDAO2;


public class MainDemoApp2 {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO2 theAccountDAO = context.getBean("accountDAO2", AccountDAO2.class);

        // call the business method
        theAccountDAO.addAccount(2);
        
     // call the business method
        theAccountDAO.removeAccount();;
        
        // close the context
        context.close();
    }

}
