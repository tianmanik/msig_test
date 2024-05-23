package com.msig.user.service;

import com.msig.user.common.Encrypt;
import com.msig.user.dto.MasterStudentDTO;
import com.msig.user.entity.MasterStudent;
import com.msig.user.entity.MasterUser;
import com.msig.user.repository.MasterStudentRepository;
import com.msig.user.repository.MasterUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterUserService {

    private MasterUserRepository userRepository;

    private MasterStudentRepository studentRepository;

    public void register (MasterStudentDTO param){
        Encrypt e = new Encrypt();
        MasterUser data = new MasterUser();
        data.setUserName(param.getUserName());
        data.setPassword(e.encrypt(param.getPassword()));
        userRepository.save(data);

        MasterStudent dataStudent = new MasterStudent();
        dataStudent.setAddress(param.getAddress());
        dataStudent.setFullName(param.getFullName());
        dataStudent.setGrade(param.getGrade());
        dataStudent.setParentName(param.getParentName());
        dataStudent.setUserName(param.getUserName());
        studentRepository.save(dataStudent);
    }






}
