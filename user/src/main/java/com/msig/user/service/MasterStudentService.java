package com.msig.user.service;

import com.msig.user.dto.MasterStudentDTO;
import com.msig.user.entity.MasterStudent;
import com.msig.user.repository.MasterStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterStudentService {

    private MasterStudentRepository studentRepository;

    public MasterStudent findByUserName (String userName){
        return studentRepository.findByUserName(userName);
    }


}
