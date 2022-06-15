package com.os.udemy.jpahibernate.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@NamedQuery(name = "studentOrphanRemoval.getAll", query = "from StudentOrphanRemoval")
public class StudentOrphanRemoval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id", nullable = false)
    private String staffId;

    private String name;
    private Integer age;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "custodian_id")
    private CustodianOrphanRemoval custodian;


}
