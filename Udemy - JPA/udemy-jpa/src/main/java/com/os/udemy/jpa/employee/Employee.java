package com.os.udemy.jpa.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     * @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName =
     * "gen_name", valueColumnName = "gen_val", allocationSize = 100)
     * 
     * @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
     */
    @GenericGenerator(name = "emp_id", strategy = "com.os.udemy.jpa.employee.CustomRandomIdGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
    long id;
    String name;

}
