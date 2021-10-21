package com.os.udemy.jpa.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product implements Serializable{
    private static final long serialVersionUID = 7872321213843005065L;
    
    @Id
    private int id;
    private String name;

    @Column(name = "description")
    private String desc;
    private Double price;

}
