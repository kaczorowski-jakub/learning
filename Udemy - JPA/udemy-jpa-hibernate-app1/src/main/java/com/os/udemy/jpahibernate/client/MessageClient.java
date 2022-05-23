package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Message;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class MessageClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageClient.class);

    public static void main(String[] args) {
        LOGGER.info("Test in MEssage Client");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Message message = new Message("Hello msg" + new Random().nextInt());   // at this point object is transient
        session.save(message);  // at this point object is persisted
        session.getTransaction().commit();  // at this point object is in the database
        session.close();    // at this point object is detached

        getMessage();
        getAndUpdateMessage(31);
        updateDetachedMessage(32);
        //deleteMessage(33L);
    }

    // no transaction needed
    private static void getMessage() {
        LOGGER.info("getMessage");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(session.get(com.os.udemy.jpahibernate.domain.Message.class, 31L));
    }

    // transaction is needed to update
    private static void getAndUpdateMessage(long id) {
        LOGGER.info("getAndUpdateMessage");

        Transaction trn = null;
        /* no save or saveOrUpdate or persist methods have to be used - just tstart and tcommit and all the
        objects in session will be updated if needed (dirty checking)
         */
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            Message msg = session.get(com.os.udemy.jpahibernate.domain.Message.class, id);
            msg.setText(msg.getText() + " After Update");
            trn.commit();
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }

        /*
        This one won't work because transaction is not autoclosable so cannot be in the try
        in finally we don't have access to session variable
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            Message msg = session.get(com.os.udemy.jpahibernate.domain.Message.class, 31L);
            msg.getText(msg.setText() + " After Update");
            session.getTransaction().commit();
        } finally {

        }
         */
    }

    private static void deleteMessage(long id) {
        LOGGER.info("deleteMessage");

        Transaction trn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            Message msg = session.get(com.os.udemy.jpahibernate.domain.Message.class, id);  // msg in perist state
            session.delete(msg);    // msg in removed state
            trn.commit();
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }
    }

    private static void updateDetachedMessage(long id) {
        LOGGER.info("updateDetachedMessage");

        // simple update
        Transaction trn = null;
        Message msg = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            msg = session.get(com.os.udemy.jpahibernate.domain.Message.class, id);  // msg is persisted
            msg.setText(msg.getText() + " After Update");
            trn.commit();  // msg is in th DB
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }   // at this point msg is detached

        msg.setText(msg.getText() + " and again");  // no effect in DB

        // update detached
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            session.update(msg);    // msg persistent again
            trn.commit();  // msg is in the DB
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }

        msg.setText("Ala ma kota"); // no effect

        // update detach with NonUniqueObjectException
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            Message msg2 = session.get(com.os.udemy.jpahibernate.domain.Message.class, id);
            session.update(msg);    // org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session
                                    // - msg2 is loaded into the session so we can't put the same object there
            trn.commit();  // msg is in th DB
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }

        // update detached without NonUniqueObjectException
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trn = session.getTransaction();
            trn.begin();
            Message msg2 = session.get(com.os.udemy.jpahibernate.domain.Message.class, id);
            session.merge(msg); // msg is persisted even though msg2 is there and it's the same object
                                // msg will be copied on msg2
            trn.commit();  // msg is in th DB
        } catch(Exception e) {
            LOGGER.error("ERROR", e);
            if (trn != null) {
                try {
                    trn.rollback();
                } catch (Exception e2) {

                }
            }
        }
    }
}
