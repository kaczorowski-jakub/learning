package com.os.udemy.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.os.udemy.spring.aop.dao.pkg2.AccountDAO3;

public class MainDemoAppPointcut {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO3 theAccountDAO = context.getBean("accountDAO3", AccountDAO3.class);
        theAccountDAO.addAccount(12);

        // close the context
        context.close();
    }

}
