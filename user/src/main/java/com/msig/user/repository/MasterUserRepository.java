package com.msig.user.repository;

import com.msig.user.entity.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterUserRepository extends JpaRepository<MasterUser,Long> {
}
