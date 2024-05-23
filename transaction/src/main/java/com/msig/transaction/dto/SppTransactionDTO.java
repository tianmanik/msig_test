package com.msig.transaction.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SppTransactionDTO {
    private Long id;
    private String userName;
    private Integer sppMonth;
    private Integer sppYear;
    private java.sql.Date createdDate;
    private String createdBy;

}
