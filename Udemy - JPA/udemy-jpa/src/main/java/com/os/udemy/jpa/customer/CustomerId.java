package com.os.udemy.jpa.customer;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CustomerId implements Serializable {
    private static final long serialVersionUID = -8973274054414626997L;
    private int id;
    private String email;
}
