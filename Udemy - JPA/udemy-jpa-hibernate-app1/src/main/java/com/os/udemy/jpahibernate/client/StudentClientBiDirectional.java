package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.CustodianBiDirectional;
import com.os.udemy.jpahibernate.domain.StudentBiDirectional;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Slf4j
public class StudentClientBiDirectional {
    public static void main(String[] args) {
        log.info("New Person");

        //createStudent();
        //getStudents();
        getCustodian();
    }

    private static void createStudent() {
/*
        Before this we can delete PERSON table to see that
        <property name="hbm2ddl.auto">update</property>
        will create it again
         */
        Session session = HibernateUtil.getSessionFactory().openSession();

        // we call just save student because we have the  on student2.custodian mapping
        session.beginTransaction();
        CustodianBiDirectional custodianBiDirectional = session.get(CustodianBiDirectional.class, 1L);
        StudentBiDirectional student = StudentBiDirectional.builder().age(17).name("John Smith 3").staffId("ABC123-3333").custodian(custodianBiDirectional).build();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }

    public static void getCustodian() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("custodianBiDirectional.getAll");
        query.getResultList().forEach(custodian -> System.out.println(custodian));
        session.close();
    }

    public static void getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("studentBiDirectional.getAll");
        query.getResultList().forEach(student -> System.out.println(student));
        session.close();
    }

    public static void deleteStudent() {
        // how to delete student with custodian which has a relation with more than one student?
        // solution-1: we can null the custodian field for the student we want to delete just before the deletion
        // solution-2: we do not mark it as cascadetpe.remove
    }
}
