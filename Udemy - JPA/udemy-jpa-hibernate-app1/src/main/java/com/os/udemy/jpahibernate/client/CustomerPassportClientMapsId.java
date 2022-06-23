package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Customer;
import com.os.udemy.jpahibernate.domain.CustomerMapsId;
import com.os.udemy.jpahibernate.domain.Passport;
import com.os.udemy.jpahibernate.domain.PassportMapsId;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;

public class CustomerPassportClientMapsId {
    public static void main(String[] args) {

        PassportMapsId passport = PassportMapsId.builder()
                .number("ABCD-1234")
                .build();
        CustomerMapsId customer = CustomerMapsId.builder()
                .name("Janusz Cebula")
                .passport(passport)
                .build();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();

    }
}
