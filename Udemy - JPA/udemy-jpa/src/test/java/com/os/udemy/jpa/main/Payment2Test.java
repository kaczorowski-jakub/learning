package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.payment.Check2;
import com.os.udemy.jpa.payment.CreditCard2;
import com.os.udemy.jpa.payment.PaymentRepository2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Payment2Test {
    
    @Autowired
    PaymentRepository2 repo;
    
    @Test
    public void PyamentCreateTest() {
        CreditCard2 cc = new CreditCard2();
        cc.setId(3);
        cc.setAmount(400d);
        cc.setCardnumber("987");
        repo.save(cc);
        
        Check2 ch = new Check2();
        ch.setId(4);
        ch.setAmount(300);
        ch.setChecknumber("XYZ999");
        repo.save(ch);
    }
    
}
