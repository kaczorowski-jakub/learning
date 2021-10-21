package com.os.udemy.jpa.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {
    private String cardnumber;
}
