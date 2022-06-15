package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Custodian;
import com.os.udemy.jpahibernate.domain.Student;
import com.os.udemy.jpahibernate.domain.Student2;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Slf4j
public class StudentClientCascade {
    public static void main(String[] args) {
        log.info("New Person");

         createStudent();
        //getStudents();
    }

    private static void createStudent() {
/*
        Before this we can delete PERSON table to see that
        <property name="hbm2ddl.auto">update</property>
        will create it again
         */

        Custodian custodian = Custodian.builder().enrollmentId("101-AB").name("Grandpa 222").build();
        Student2 student = Student2.builder().age(17).name("John Smith 2").staffId("ABC123").custodian(custodian).build();

        Session session = HibernateUtil.getSessionFactory().openSession();

        // we call just save student because we have the  on student2.custodian mapping
         session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }

    public static void getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("student2.getAll");
        query.getResultList().forEach(student -> System.out.println(student));
        session.close();
    }

    public static void deleteStudent() {
        // how to delete student with custodian which has a relation with more than one student?
        // solution-1: we can null the custodian field for the student we want to delete just before the deletion
        // solution-2: we do not mark it as cascadetpe.remove
    }
}
