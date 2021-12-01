package com.os.udemy.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.os.udemy.spring.aop.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		theAccountDAO.findAccounts2();
		
		// close the context
		context.close();
	}

}










