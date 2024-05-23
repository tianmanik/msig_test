package com.msig.transaction.repository;

import com.msig.transaction.entity.MasterStudent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceClient {

    @GetMapping("/student/{userName}")
    MasterStudent getStudent(@PathVariable("userName") String userName);
}
