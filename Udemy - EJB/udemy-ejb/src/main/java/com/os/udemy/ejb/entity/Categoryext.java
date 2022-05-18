package com.os.udemy.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Categoryext.findAll", query = "SELECT c FROM Categoryext c"),
        @NamedQuery(name = "Categoryext.findBySeq", query = "SELECT c FROM Categoryext c where c.seq=:seq") })
public class Categoryext implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    private String tag;

    @Column(name = "category_id")
    private String categoryId;

    public Categoryext() {
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Integer getSeq() {
        return seq;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return seq + " - " + tag;
    }

}