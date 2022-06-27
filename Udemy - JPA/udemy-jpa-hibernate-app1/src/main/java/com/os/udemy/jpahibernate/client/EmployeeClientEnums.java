package com.os.udemy.jpahibernate.client;

import com.os.udemy.jpahibernate.domain.Employee;
import com.os.udemy.jpahibernate.domain.EmployeeSex;
import com.os.udemy.jpahibernate.domain.EmployeeStatus;
import com.os.udemy.jpahibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeClientEnums {
    public static void main(String[] args) {
        createEmployee();
        readEmployees();
    }

    private static void createEmployee() {
        Employee employee = Employee.builder()
                .name("Aron")
                .sex(EmployeeSex.MALE)
                .status(EmployeeStatus.FULL_TIME)
                .build();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    private static void readEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("employee.getAll");
        query.getResultList().forEach(empl -> System.out.println(empl));
        session.close();
    }
}
