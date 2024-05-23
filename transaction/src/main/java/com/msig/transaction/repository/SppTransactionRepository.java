package com.msig.transaction.repository;

import com.msig.transaction.entity.SppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SppTransactionRepository extends JpaRepository<SppTransaction,Long> {

    List<SppTransaction> findByUserName(String userName);
}
