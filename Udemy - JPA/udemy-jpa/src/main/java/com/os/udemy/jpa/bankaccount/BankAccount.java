package com.os.udemy.jpa.bankaccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bankaccount")
public class BankAccount {
    
    @Id
    private int accno;
    
    @Column(name = "firstname")
    private String fristName;
    
    @Column(name = "lastname")
    private String lastName;
    
    private int bal;
}
