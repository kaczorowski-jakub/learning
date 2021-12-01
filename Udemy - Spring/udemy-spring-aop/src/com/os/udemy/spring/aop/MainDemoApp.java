package com.os.udemy.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.os.udemy.spring.aop.dao.AccountDAO;
import com.os.udemy.spring.aop.dao.MembershipDAO;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        theAccountDAO.addAccount();

        // do it again!
        System.out.println("\nlet's call it again!\n");

        // call the business method again
        theAccountDAO.addAccount();

        // get membership bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the membership business method
        theMembershipDAO.addSillyMember();

        // close the context
        context.close();
    }

}
