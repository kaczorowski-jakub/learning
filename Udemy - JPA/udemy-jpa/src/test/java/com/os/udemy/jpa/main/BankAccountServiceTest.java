package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.bankaccount.BankAccountService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BankAccountServiceTest {
    
    @Autowired
    BankAccountService service;
    
    @Test
    public void test1() {
        service.transfer(400);
    }
    
}
