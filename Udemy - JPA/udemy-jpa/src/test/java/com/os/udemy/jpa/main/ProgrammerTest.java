package com.os.udemy.jpa.main;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.programmer.Programmer;
import com.os.udemy.jpa.programmer.ProgrammerRepository;
import com.os.udemy.jpa.programmer.Project;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProgrammerTest {
    
    @Autowired
    ProgrammerRepository repo;
    
    @Test
    public void createProgrammer() {
        Programmer programmer1 = Programmer.builder().name("John").salary(4000).build();
        Programmer programmer2 = Programmer.builder().name("Carol").salary(4100).build();
        Project project1 = Project.builder().name("Java JPA").build();
        Project project2 = Project.builder().name("Udemy").build();
        
        programmer1.addProject(project1);
        programmer1.addProject(project2);
        
        programmer2.addProject(project2);
        
        repo.save(programmer1);
        repo.save(programmer2);
        
    }
    
    @Test
    @Transactional
    public void findProgrammer() {
        Programmer p = repo.findById(5).get();
        System.out.println(p.getName() + ", " + p.getSalary());
        p.getProjects().forEach(proj -> System.out.println(proj.getName()));
        
    }
    
}
