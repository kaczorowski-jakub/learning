package com.os.udemy.spring.aop.dao.pkg1;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO2 {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void addAccount(int a) {
        
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with " + a);
        
    }
	
	public void removeAccount() {
        
        System.out.println(getClass() + ": DOING MY DB WORK: REMOVING AN ACCOUNT");
        
    }
}
