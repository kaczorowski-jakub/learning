package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.payment.Check3;
import com.os.udemy.jpa.payment.CreditCard3;
import com.os.udemy.jpa.payment.PaymentRepository3;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Payment3Test {
    
    @Autowired
    PaymentRepository3 repo;
    
    @Test
    public void PyamentCreateTest() {
        CreditCard3 cc = new CreditCard3();
        cc.setId(3);
        cc.setAmount(400d);
        cc.setCardnumber("987");
        repo.save(cc);
        
        Check3 ch = new Check3();
        ch.setId(4);
        ch.setAmount(300);
        ch.setChecknumber("XYZ999");
        repo.save(ch);
    }
    
}
