package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.*;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ParentClientCompositePK {
    public static void main(String[] args) {
        createParent();
        readParents();
    }

    /**
     * Change the names
     */
    private static void createParent() {
        Parent parent = Parent.builder()
                .age(76)
                .email("new@old.pl")
                .parentPrimaryKey(new ParentPrimaryKey("John2", "Smith2"))
                .build();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(parent);
        session.getTransaction().commit();
        session.close();
    }

    private static void readParents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("parent.getAll");
        query.getResultList().forEach(parent -> System.out.println(parent));
        session.close();
    }
}
