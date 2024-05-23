package com.msig.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spp_transaction")
@Getter
@Setter
public class SppTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spp_transaction_id_seq_generator")
    @SequenceGenerator(name = "spp_transaction_id_seq_generator", sequenceName = "spp_transaction_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "spp_month")
    private Integer sppMonth;

    @Column(name = "spp_year")
    private Integer sppYear;

    @Column(name = "created_date")
    private java.util.Date createdDate;

    @Column(name = "created_by")
    private String createdBy;


}
