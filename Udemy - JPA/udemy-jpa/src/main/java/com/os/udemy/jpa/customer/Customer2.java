package com.os.udemy.jpa.customer;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer2 {
    
    @EmbeddedId
    private CustomerId id;
    private String name;
    
}
