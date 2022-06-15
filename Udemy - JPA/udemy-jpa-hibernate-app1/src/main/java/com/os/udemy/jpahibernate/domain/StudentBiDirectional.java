package com.os.udemy.jpahibernate.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@NamedQuery(name = "studentBiDirectional.getAll", query = "from StudentBiDirectional")
public class StudentBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id", nullable = false)
    private String staffId;

    private String name;
    private Integer age;

    // this is the owner of the relationship because it has a foreign key
    // and this is why we have the JoinColumn annotation here
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "custodian_id")
    private CustodianBiDirectional custodian;


}
