package com.msig.transaction.entity;

import com.msig.transaction.dto.MasterStudentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_student")
@Getter
@Setter
public class MasterStudent {
    @Id
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

    public MasterStudentDTO toDTO() {
        MasterStudentDTO x = new MasterStudentDTO();
        x.setFullName( this.fullName );
        x.setAddress(this.address);
        x.setParentName(this.parentName);
        x.setGrade(this.grade) ;
        x.setUserName(this.userName );

        return x;
    }
}
