package com.os.udemy.jpa.image;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Image {

    @Id
    int id;

    String name;

    byte[] data;

}
