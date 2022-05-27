package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Address;
import com.os.udemy.jpahibernate.domain.Person;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class PersonClient {
    public static void main(String[] args) {
        log.info("New Person");
        /*
        Before this we can delete PERSON table to see that
        <property name="hbm2ddl.auto">update</property>
        will create it again
         */
        Person person = new Person();
        person.setName("Jakub Kaczorowski");
        person.setHomeAddress(new Address("Jan Brzechwy 12", "Warszawa", "12-345"));
        person.setMailAddress(new Address("Krzywa 32", "Bydgoszcz", "44-098"));


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
