package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Actor;
import com.os.udemy.jpahibernate.domain.Movie;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * The owner (Movie) is responsible for the relationship -> movie_actor table
 */
public class ActorMovieManyToManyClient {
    public static void main(String[] args) {
        //createRecord();
        //updateInverseEnd();
        updateTheOwner();
    }

    private static void createRecord() {
        Actor actor1 = Actor.builder()
                .firstName("Sylwester")
                .lastName("Stallone")
                .build();
        Actor actor2 = Actor.builder()
                .firstName("Monica")
                .lastName("Belucci")
                .build();

        Movie movie1 = Movie.builder()
                .name("Funny movie")
                .year(2011)
                .build();
        movie1.addActor(actor1);
        movie1.addActor(actor2);

        Movie movie2 = Movie.builder()
                .name("Sad movie")
                .year(2021)
                .build();
        movie2.addActor(actor1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(movie1);
        session.persist(movie2);
        session.getTransaction().commit();
        session.close();
    }

    private static void updateInverseEnd(){
        // this will not update the movie_actor because actor is not the owner
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, 3L);
        Actor actor = session.get(Actor.class, 1L);
        actor.addMovie(movie);
        session.persist(actor);
        session.getTransaction().commit();
        session.close();
    }

    private static void updateTheOwner(){
        // this will work because movie is the owner
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, 3L);
        Actor actor = session.get(Actor.class, 1L);
        movie.addActor(actor);
        session.persist(movie);
        session.getTransaction().commit();
        session.close();
    }
}
