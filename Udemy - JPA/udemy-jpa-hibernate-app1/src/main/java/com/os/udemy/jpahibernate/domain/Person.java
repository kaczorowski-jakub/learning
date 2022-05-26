package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="home_street")),
            @AttributeOverride(name="city", column=@Column(name="home_city")),
            @AttributeOverride(name="zip", column=@Column(name="home_zip"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="mail_street")),
            @AttributeOverride(name="city", column=@Column(name="mail_city")),
            @AttributeOverride(name="zip", column=@Column(name="mail_zip"))
    })
    private Address mailAddress;
}
