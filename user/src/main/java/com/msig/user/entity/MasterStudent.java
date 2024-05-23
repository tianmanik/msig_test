package com.msig.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_student")
@Getter
@Setter
public class MasterStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_student_id_seq_generator")
    @SequenceGenerator(name = "master_student_id_seq_generator", sequenceName = "master_student_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "grade")
    private Long grade;

    @Column(name = "user_name")
    private String userName;

}
