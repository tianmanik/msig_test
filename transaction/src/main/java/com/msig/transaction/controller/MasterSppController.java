package com.msig.transaction.controller;

import com.msig.transaction.common.GenericResponseDTO;
import com.msig.transaction.dto.MasterSppDTO;
import com.msig.transaction.service.MasterSppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spp")
@AllArgsConstructor
public class MasterSppController {

    private MasterSppService sppService;

    @PostMapping("/")
    public GenericResponseDTO save (@RequestBody MasterSppDTO param){
        GenericResponseDTO responseDTO = new GenericResponseDTO();
        try {
            sppService.save(param);
        }catch (Exception e){
            return responseDTO.errorResponse(400,e.getMessage());
        }

        return responseDTO.successResponse();
    }

    @GetMapping("/{userName}")
    public GenericResponseDTO getAllSppDetail(@PathVariable("userName") String userName){
        GenericResponseDTO responseDTO = new GenericResponseDTO();

        return responseDTO.successResponse(sppService.getAllSppDetail(userName));
    }

}
