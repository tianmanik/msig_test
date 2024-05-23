package com.msig.transaction.controller;

import com.msig.transaction.common.GenericResponseDTO;
import com.msig.transaction.dto.SppTransactionDTO;
import com.msig.transaction.entity.SppTransaction;
import com.msig.transaction.service.SppTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaksi")
@AllArgsConstructor
public class SppTransactionController {

    private SppTransactionService transactionService;

    @PostMapping("/spp")
    public GenericResponseDTO save (@RequestBody SppTransactionDTO param){
        GenericResponseDTO responseDTO = new GenericResponseDTO();

        List<SppTransaction> dataPembayaran = transactionService.findByUserName(param.getUserName());
        for(SppTransaction x : dataPembayaran){
            if( (x.getSppMonth().equals(param.getSppMonth()) && x.getSppYear().equals( param.getSppYear() ))   ){
                return responseDTO.errorResponse(400,"SPP Pada Bulan Dan Tahun Tersebut Telah Dibayar");
            }
        }
        try{
            transactionService.save(param);
        }catch (Exception e){
            return responseDTO.errorResponse(400,e.getMessage());
        }

        return responseDTO.successResponse();
    }

}
