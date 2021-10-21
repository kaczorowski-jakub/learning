package com.os.udemy.jpa.payment;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bankcheck")
public class Check2 extends Payment2 {
    private String checknumber;
}
