package com.os.udemy.jpa.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.employee.Employee;
import com.os.udemy.jpa.employee.EmployeeRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EmployeeTest {
    
    @Autowired
    EmployeeRepository repo;
    
    @Test
    public void createEmployeeTest() {
        
        Employee e = new Employee();
        e.setName("Mike");
        repo.save(e);
    }
}
