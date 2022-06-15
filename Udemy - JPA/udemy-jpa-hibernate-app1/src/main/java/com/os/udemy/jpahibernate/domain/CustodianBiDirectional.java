package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "custodianBiDirectional.getAll", query = "from CustodianBiDirectional")
public class CustodianBiDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "enrollment_id", nullable = false)
    private String enrollmentId;

    // this is NOT an owner of the relationship - see Student3
    @OneToMany(mappedBy = "custodian", cascade = {CascadeType.PERSIST})
    private List<StudentBiDirectional> students;

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append(id + ", " + enrollmentId);
        sb.append(", custodians[");
        students.forEach(studentBiDirectional -> sb.append(studentBiDirectional.getId() + " -> " + studentBiDirectional.getName() + ", " + studentBiDirectional.getAge()));
        sb.append("]");
        return sb.toString();
    }

    public void addStudent(StudentBiDirectional student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setCustodian(this);
    }
}
