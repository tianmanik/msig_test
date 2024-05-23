package com.msig.user.controller;

import com.msig.user.common.GenericResponseDTO;
import com.msig.user.dto.MasterStudentDTO;

import com.msig.user.service.MasterUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class MasterUserController {

    private MasterUserService userService;

    @PostMapping("/register")
    public GenericResponseDTO register (@RequestBody MasterStudentDTO param){
        GenericResponseDTO responseDTO = new GenericResponseDTO();

        try {
            userService.register(param);
        }catch (Exception e){
            return responseDTO.errorResponse(400,e.getMessage());
        }
        return responseDTO.successResponse();
    }




}
