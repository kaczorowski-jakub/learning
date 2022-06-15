package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.CustodianUniDirectional;
import com.os.udemy.jpahibernate.domain.StudentUniDirectional;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class StudentClientUniDirectional {
    public static void main(String[] args) {
        log.info("New Person");

        createCustodian();
        //getCustodian();
    }

    private static void createCustodian() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        CustodianUniDirectional custodianUniDirectional = CustodianUniDirectional.builder()
                .name("UniCustodian")
                .enrollmentId("Uni-ID")
                .build();
        StudentUniDirectional student41 = StudentUniDirectional.builder()
                .age(98)
                .name("Uni-Student-1")
                .staffId("Staff-1")
                .build();
        StudentUniDirectional student42 = StudentUniDirectional.builder()
                .age(67)
                .name("Uni-Student-2")
                .staffId("Staff-2")
                .build();
        custodianUniDirectional.addStudent(student41);
        custodianUniDirectional.addStudent(student42);

        session.persist(custodianUniDirectional);
        session.getTransaction().commit();
        session.close();
    }

    private static void getCustodian() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CustodianUniDirectional custodianUniDirectional = session.get(CustodianUniDirectional.class,1L);
        session.close();
    }
}
