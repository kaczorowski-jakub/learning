package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Customer;
import com.os.udemy.jpahibernate.domain.Passport;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;

public class CustomerPassportClientOneToOne {
    public static void main(String[] args) {

        Passport passport = Passport.builder()
                .number("ABCD-1234")
                .build();
        Customer customer = Customer.builder()
                .name("Janusz Cebula")
                .passport(passport)
                .build();
        passport.setCustomer(customer);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();

    }
}
