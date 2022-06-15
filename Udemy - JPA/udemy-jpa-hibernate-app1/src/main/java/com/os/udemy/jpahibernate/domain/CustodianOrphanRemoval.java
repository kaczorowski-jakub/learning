package com.os.udemy.jpahibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "custodianOrphanRemoval.getAll", query = "from CustodianOrphanRemoval")
public class CustodianOrphanRemoval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "enrollment_id", nullable = false)
    private String enrollmentId;

    @OneToMany(mappedBy = "custodian", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private List<StudentOrphanRemoval> students;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id + ", " + enrollmentId);
        sb.append(", custodians[");
        students.forEach(student3 -> sb.append(student3.getId() + " -> " + student3.getName() + ", " + student3.getAge()));
        sb.append("]");
        return sb.toString();
    }

    public void addStudent(StudentOrphanRemoval student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setCustodian(this);
    }
}
