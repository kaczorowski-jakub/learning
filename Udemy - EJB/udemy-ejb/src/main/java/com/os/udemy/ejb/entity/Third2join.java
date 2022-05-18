package com.os.udemy.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Third2join.findAll", query = "SELECT t2j FROM Third2join t2j")
public class Third2join implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String someText;
    @Column(name = "categoryext_id")
    private int categoryextId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public int getCategoryextId() {
        return categoryextId;
    }

    public void setCategoryextId(int categoryextId) {
        this.categoryextId = categoryextId;
    }

    @Override
    public String toString() {
        return id + " " + someText;
    }

}
