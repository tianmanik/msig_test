package com.msig.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterStudentDTO extends MasterUserDTO{
    private Long id;
    private String fullName;
    private String address;
    private String parentName;
    private Long grade;
    private String userName;


}
