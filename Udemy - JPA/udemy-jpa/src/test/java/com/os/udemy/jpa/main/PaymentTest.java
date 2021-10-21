package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.payment.Check;
import com.os.udemy.jpa.payment.CreditCard;
import com.os.udemy.jpa.payment.PaymentRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PaymentTest {
    
    @Autowired
    PaymentRepository repo;
    
    @Test
    public void PyamentCreateTest() {
        CreditCard cc = new CreditCard();
        cc.setId(3);
        cc.setAmount(400d);
        cc.setCardnumber("987");
        repo.save(cc);
        
        Check ch = new Check();
        ch.setId(4);
        ch.setAmount(300);
        ch.setChecknumber("XYZ999");
        repo.save(ch);
    }
    
}
