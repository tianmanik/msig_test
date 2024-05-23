package com.msig.user.repository;

import com.msig.user.entity.MasterStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterStudentRepository extends JpaRepository<MasterStudent,Long> {

    MasterStudent findByUserName(String userName);


}
