package com.msig.transaction.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MasterStudentDTO {
    private Long id;
    private String fullName;
    private String address;
    private String parentName;
    private Long grade;
    private String userName;
    MasterSppDTO detailSpp;
    private Long total;

}
