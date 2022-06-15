package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Address;
import com.os.udemy.jpahibernate.domain.Custodian;
import com.os.udemy.jpahibernate.domain.Person;
import com.os.udemy.jpahibernate.domain.Student;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Slf4j
public class StudentClient {
    public static void main(String[] args) {
        log.info("New Person");

        //createStudent();
        getStudents();
    }

    private static void createStudent() {
/*
        Before this we can delete PERSON table to see that
        <property name="hbm2ddl.auto">update</property>
        will create it again
         */

        Custodian custodian = Custodian.builder().enrollmentId("101-AB").name("Grandpa").build();
        Student student = Student.builder().age(17).name("John Smith").staffId("ABC123").custodian(custodian).build();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // we call it twice because we don't have cascade
        session.save(student);
        session.save(custodian);
        session.getTransaction().commit();
        session.close();
    }

    public static void getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("student.getAll");
        query.getResultList().forEach(student -> System.out.println(student));
        session.close();
    }
}
