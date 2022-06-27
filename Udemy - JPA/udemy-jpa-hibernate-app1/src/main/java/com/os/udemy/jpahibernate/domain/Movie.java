package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String name;
    private int year;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actors;

    public void addActor(Actor actor) {
        if (actors == null) {
            actors = new HashSet<>();
        }
        actors.add(actor);
    }
}
