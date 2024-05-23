package com.msig.transaction.entity;

import com.msig.transaction.dto.MasterSppDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_spp")
@Getter
@Setter
public class MasterSpp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_spp_id_seq_generator")
    @SequenceGenerator(name = "master_spp_id_seq_generator", sequenceName = "master_spp_id_seq", allocationSize=1)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "jumlah_spp")
    private Long jumlahSpp;

    public MasterSppDTO toDTO (){
        MasterSppDTO x = new MasterSppDTO();
        x.setJumlahSpp(this.jumlahSpp);
        x.setUserName(this.userName);
        return x;
    }
}
