package com.os.udemy.jpa.payment;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bankcheck2")
@PrimaryKeyJoinColumn(name = "id")
public class Check3 extends Payment3 {
    private String checknumber;
}
