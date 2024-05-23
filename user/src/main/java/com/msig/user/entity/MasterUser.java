package com.msig.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "master_user")
public class MasterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_user_id_seq_generator")
    @SequenceGenerator(name = "master_user_id_seq_generator", sequenceName = "master_user_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

}
