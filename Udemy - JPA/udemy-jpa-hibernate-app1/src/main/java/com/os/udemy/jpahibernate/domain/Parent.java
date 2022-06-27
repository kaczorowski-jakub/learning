package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "parent.getAll", query = "from Parent")
@ToString
public class Parent {

    @EmbeddedId
    private ParentPrimaryKey parentPrimaryKey;

    private int age;

    private String email;
}
