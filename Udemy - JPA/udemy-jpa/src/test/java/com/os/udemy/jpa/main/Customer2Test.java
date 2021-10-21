package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.customer.Customer2;
import com.os.udemy.jpa.customer.Customer2Repository;
import com.os.udemy.jpa.customer.CustomerId;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Customer2Test {
    
    @Autowired
    Customer2Repository repo;
    
    @Test
    public void customerCreate() {
//        Customer2 c = new Customer2();
//        c.setName("John Bush");
//        c.setEmail("test@wp.pl");
//        c.setId(2);
//        
//        repo.save(c);
    }
    
    @Test
    public void customerCreate2() {
        Customer2 c = new Customer2();
        c.setName("John Bush");
        CustomerId id = new CustomerId();
        id.setEmail("a@b.pl");
        id.setId(1);
        c.setId(id);
        
        repo.save(c);
    }
}
