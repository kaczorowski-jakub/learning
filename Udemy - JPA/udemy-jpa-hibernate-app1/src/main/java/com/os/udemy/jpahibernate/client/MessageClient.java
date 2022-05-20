package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Message;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;

public class MessageClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Message message = new Message("Hello msg-1");   // at this point object is transient
        session.save(message);  // at this point object is persisted
        session.getTransaction().commit();
        session.close();    // at this point object is detached
    }
}
