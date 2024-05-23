package com.msig.user.controller;

import com.msig.user.entity.MasterStudent;
import com.msig.user.service.MasterStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class MasterStudentController {
    private MasterStudentService studentService;

    @GetMapping("/{userName}")
    public MasterStudent getStudent (@PathVariable("userName") String userName){
        return studentService.findByUserName(userName);
    }
}
