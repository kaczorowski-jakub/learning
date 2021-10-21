package com.os.udemy.jpa.main;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.customer.Customer;
import com.os.udemy.jpa.customer.CustomerRepository;
import com.os.udemy.jpa.customer.Phone;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerTest {
    
    @Autowired
    CustomerRepository repo;
    
    @Test
    public void customerCreate() {
        Customer c = new Customer();
        c.setName("John Bush");
       
        Phone p1 = new Phone();
        p1.setType("Home No");
        p1.setNumber("1234");
        c.addNumber(p1);
        
        
        Phone p2 = new Phone();
        p2.setType("Cell No");
        p2.setNumber("9876");
        c.addNumber(p2);
        
        repo.save(c);
        
    }
    
    @Test
    @Transactional
    public void readCustomers() {
        Customer c = repo.findById(3L).get();
        System.out.println(c.getName());
        c.getNumbers().forEach(phone -> System.out.println(phone.getNumber()));
    }
    
    @Test
    public void updateCustomers() {
        Customer c = repo.findById(4L).get();
        c.getNumbers().forEach(phone -> phone.setType("Cell No"));
        repo.save(c);
    }
    
    @Test
    public void testDelete() {
        repo.deleteById(3L);
    }
    
}
