package com.os.udemy.jpa.client;

import com.os.udemy.jpahibernate.domain.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Persistence context is a service which:
 * - remembers all the modifications
 * - state changes made to the data
 * in a particular unit of work
 * <p>
 * it also does automatic dirty checking
 */
public class HelloWorldClient {
    public static void main(String[] args) {

        basicExample();
        exceptionOnDelete();
        whatWillBeStored();
        labCache();
        customDirtyChecking();
        forceDirtyCheck();
    }

    private static void basicExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
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
    }

    private static void exceptionOnDelete() {
        // exception deleting a detached object
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
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
    }

    private static void whatWillBeStored() {
        // nothing will be stored persist and
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
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

    private static void labCache() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Message msg = em.find(Message.class, 43L);
            msg = em.merge(msg);
            em.detach(msg);
            em.remove(msg);
            msg = em.merge(msg);
            System.out.println(em.contains(msg));
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

    private static void customDirtyChecking() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Message msg = em.find(Message.class, 44L);
            msg.setText("Dirtiness checking");
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
    }

    private static void forceDirtyCheck() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");   // persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Message msg = em.find(Message.class, 45L);
            msg.setText("force dirty checking");
            em.flush(); // here will be dirty checking and update
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
    }
}
