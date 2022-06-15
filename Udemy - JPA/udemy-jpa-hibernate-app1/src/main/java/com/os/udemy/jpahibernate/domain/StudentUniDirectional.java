package com.os.udemy.jpahibernate.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@NamedQuery(name = "studentUniDirectional.getAll", query = "from StudentUniDirectional")
// StudentUniDirectional and CustodianUniDirectional are uni-directional
public class StudentUniDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id", nullable = false)
    private String staffId;

    private String name;
    private Integer age;
}
