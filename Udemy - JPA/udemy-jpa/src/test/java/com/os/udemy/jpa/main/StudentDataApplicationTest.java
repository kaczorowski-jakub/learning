package com.os.udemy.jpa.main;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.student.Student;
import com.os.udemy.jpa.student.StudentRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentDataApplicationTest {

    @Autowired
    StudentRepository repo;

    @Test
    public void testCreate() {
        Student student = new Student();
        student.setFirstName("Bill");
        student.setLastName("Gates");
        student.setScore(101);

        repo.save(student);
    }

    @Test
    public void findAllStudents() {
        repo.findAllStudents().forEach(s -> System.out.println(s));
    }

    @Test
    public void findAllStudentsPartial() {
        List<Object[]> list = repo.findPartialAllStudents();
        for (Object[] el : list) {
            for (Object o : el) {
                System.out.print(o);
            }
            System.out.println("---");
        }
    }

    @Test
    public void findAllStudentsByFristName() {
        repo.findAllStudentsByFirstName("Bill").forEach(s -> System.out.println(s));
    }

    @Test
    public void findAllStudentsByScore() {
        repo.findAllStudentsByScore(1, 15).forEach(s -> System.out.println(s));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentQuery() {
        repo.deleteStudentsByFirstName("Bill");
    }

    @Test
    public void findAllStudentsPaging() {
        repo.findAllStudents(PageRequest.of(0, 4, Direction.ASC, "lastName")).forEach(s -> System.out.println(s));
    }
    
    @Test
    public void findAllStudentsNQ() {
        repo.finaAllStudentsNQ().forEach(s -> System.out.println(s));
    }
    
    @Test
    public void findByFirstNameNQ() {
        repo.finaByFirstNameNQ("John").forEach(s -> System.out.println(s));
    }

}
