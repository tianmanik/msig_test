package com.msig.transaction.service;


import com.msig.transaction.dto.SppTransactionDTO;
import com.msig.transaction.entity.SppTransaction;
import com.msig.transaction.repository.SppTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SppTransactionService {

    private SppTransactionRepository transactionRepository;

    public void save(SppTransactionDTO param){
        SppTransaction data = new SppTransaction();
        data.setCreatedBy(param.getUserName());
        data.setUserName(param.getUserName());
        data.setSppMonth(param.getSppMonth());
        data.setSppYear(param.getSppYear());
        data.setCreatedDate(new Date());
        transactionRepository.save(data);
    }

    public List<SppTransaction> findByUserName(String userName){
        return transactionRepository.findByUserName(userName);
    }
}
