package com.os.udemy.jpa.employee;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
