package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Friend;
import com.os.udemy.jpahibernate.domain.FriendAddress;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;

public class FriendClientCollectionValueType {
    public static void main(String[] args) {
        createFriend();
        readFriends();
    }

    private static void createFriend() {

        FriendAddress fa1 = FriendAddress.builder()
                .city("New York")
                .street("Blv Avn 1")
                .zip("12-098")
                .build();
        FriendAddress fa2 = FriendAddress.builder()
                .city("Warsow")
                .street("Testing")
                .zip("99987")
                .build();

        Friend friend = Friend.builder()
                .name("Mark")
                .email("mark@wp.pl")
                .nicknames(Arrays.asList("marco", "polo", "mitch"))
                .addresses(Arrays.asList(fa1, fa2))
                .build();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(friend);
        session.getTransaction().commit();
        session.close();
    }

    private static void readFriends() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("friend.getAll");
        query.getResultList().forEach(friend -> System.out.println(friend));
        session.close();
    }
}
