package com.os.udemy.jpa.payment;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "card")
public class CreditCard2 extends Payment2 {
    private String cardnumber;
}
