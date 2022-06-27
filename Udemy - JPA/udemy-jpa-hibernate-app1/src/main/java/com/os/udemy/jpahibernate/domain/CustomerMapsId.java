package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMapsId {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passport_id")
    @MapsId
    private PassportMapsId passport;
}
