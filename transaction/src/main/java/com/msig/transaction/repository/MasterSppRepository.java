package com.msig.transaction.repository;

import com.msig.transaction.dto.MasterSppDTO;
import com.msig.transaction.entity.MasterSpp;
import com.msig.transaction.entity.MasterStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterSppRepository extends JpaRepository<MasterSpp,Long> {

     MasterSpp findByUserName(String userName);
}
