package com.os.udemy.jpa.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("ch")
public class Check extends Payment {
    private String checknumber;
}
