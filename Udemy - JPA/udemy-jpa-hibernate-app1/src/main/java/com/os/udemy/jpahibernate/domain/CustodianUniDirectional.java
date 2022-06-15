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
@NamedQuery(name = "custodianUniDirectional.getAll", query = "from CustodianUniDirectional")
public class CustodianUniDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "enrollment_id", nullable = false)
    private String enrollmentId;

    // this is a uni-directional oneToMany mapping
    // hibernate will create a helper table custodian_student with students_id and guide_id columns...
    // ...to do the mapping
    // we should avoid something like this for the performance sake
    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<StudentUniDirectional> students;

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append(id + ", " + enrollmentId);
        sb.append(", custodians[");
        students.forEach(studentUniDirectional -> sb.append(studentUniDirectional.getId() + " -> " + studentUniDirectional.getName() + ", " + studentUniDirectional.getAge()));
        sb.append("]");
        return sb.toString();
    }

    public void addStudent(StudentUniDirectional studentUniDirectional) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(studentUniDirectional);
    }
}
