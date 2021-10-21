package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.employee.Address;
import com.os.udemy.jpa.employee.Employee2;
import com.os.udemy.jpa.employee.EmployeeRepository2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Employee2Test {
    
    @Autowired
    EmployeeRepository2 repo;
    
    @Test
    public void createEmployeeTest() {
        
        Employee2 e = new Employee2();
        e.setName("Mike");
        Address address = new Address();
        address.setCity("Denver");
        address.setCountry("USA");
        address.setState("Utah");
        address.setStreetaddress("Avn. 12th");
        address.setZipcode("123-ABC");
        e.setAddress(address);
        repo.save(e);
    }
}
