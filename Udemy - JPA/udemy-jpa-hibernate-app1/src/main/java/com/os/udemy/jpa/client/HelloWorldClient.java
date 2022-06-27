package com.os.udemy.jpa.client;

import com.os.udemy.jpahibernate.domain.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloWorldClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Message msg = new Message("Hello JPA"); // transient
            em.persist(msg);    // persisted in persistence context
            txn.commit();   // detached
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        // exception deleting a detached object
        try {
            em = emf.createEntityManager();
            txn = em.getTransaction();
            Message msg = em.find(Message.class, 43L);
            em.detach(msg);
            em.remove(msg);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        try {
            em = emf.createEntityManager();
            txn = em.getTransaction();
            Message msg = new Message("Hello JPA after detach"); // transient
            em.persist(msg);    // persisted in persistence context
            em.detach(msg);
            txn.commit();   // detached
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
