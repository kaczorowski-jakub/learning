package com.os.udemy.jpa.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Product {
    
    @Id
    private String id;
    private String name;
    private float price;
}
