package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.*;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class StudentClientOrphanRemoval {
    public static void main(String[] args) {
        log.info("New StudentClientOrphanRemoval");

        //testCustodianCreateRemoval();
        testCustodianCreateRemovalOrphan();
    }

    private static void testCustodianCreateRemoval() {

        // creation
        CustodianBiDirectional custodianBiDirectional = CustodianBiDirectional.builder()
                .name("Custodian Test")
                .enrollmentId("Enroll-Test")
                .build();

        StudentBiDirectional studentBiDirectional1 = StudentBiDirectional.builder()
                .age(101)
                .name("stud-test1")
                .staffId("staff-1")
                .build();

        StudentBiDirectional studentBiDirectional2 = StudentBiDirectional.builder()
                .age(22)
                .name("stud-test2")
                .staffId("staff-2")
                .build();

        custodianBiDirectional.addStudent(studentBiDirectional1);
        custodianBiDirectional.addStudent(studentBiDirectional2);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(custodianBiDirectional);
        session.getTransaction().commit();
        session.close();

        // removing student
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            StudentBiDirectional sbd = session.get(StudentBiDirectional.class, studentBiDirectional1.getId());
            session.delete(sbd);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        // removing student
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            CustodianBiDirectional cbd = session.get(CustodianBiDirectional.class, custodianBiDirectional.getId());
            session.delete(cbd);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        // after this we will get two errors
    }

    private static void testCustodianCreateRemovalOrphan() {

        // creation
        CustodianOrphanRemoval custodianOrphanRemoval = CustodianOrphanRemoval.builder()
                .name("Custodian Test")
                .enrollmentId("Enroll-Test")
                .build();

        StudentOrphanRemoval studentOrphanRemoval1 = StudentOrphanRemoval.builder()
                .age(101)
                .name("stud-test1")
                .staffId("staff-1")
                .build();

        StudentOrphanRemoval studentOrphanRemoval2 = StudentOrphanRemoval.builder()
                .age(22)
                .name("stud-test2")
                .staffId("staff-2")
                .build();

        custodianOrphanRemoval.addStudent(studentOrphanRemoval1);
        custodianOrphanRemoval.addStudent(studentOrphanRemoval2);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(custodianOrphanRemoval);
        session.getTransaction().commit();
        session.close();

        // removing student
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        StudentOrphanRemoval sor = session.get(StudentOrphanRemoval.class, studentOrphanRemoval1.getId());
        session.delete(sor);
        session.getTransaction().commit();
        session.close();

        // after this we will have no student objects neither custodian object
    }
}
