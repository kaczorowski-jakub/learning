package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedQuery(name = "friend.getAll", query = "from Friend")
/**
 * in DB we should mark friend_id and nickname in friend_nickname as primary key
 */
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "friend_nickname", joinColumns = @JoinColumn(name = "friend_id"))
    @Column(name = "nickname")
    private Collection<String> nicknames = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "friend_address", joinColumns = @JoinColumn(name = "friend_id"))
    private Collection<FriendAddress> addresses = new ArrayList<>();
}
