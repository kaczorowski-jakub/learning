package com.os.udemy.jpa.student;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select firstName, lastName from Student st")
    List<Object[]> findPartialAllStudents();

    @Query("from Student st where firstName=:fn")
    List<Student> findAllStudentsByFirstName(@Param("fn") String firstName);

    @Query("from Student st where score between :min and :max")
    List<Student> findAllStudentsByScore(@Param("min") int minimum, @Param("max") int maximum);

    @Modifying
    @Query("delete from Student where firstName=:fn")
    void deleteStudentsByFirstName(@Param("fn") String firstName);

    @Query(value = "select * from student", nativeQuery = true)
    List<Student> finaAllStudentsNQ();

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Student> finaByFirstNameNQ(@Param("firstName") String fname);
}
