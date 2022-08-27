package com.microservice.userservice.service;

import com.microservice.userservice.dto.DepartmentDTO;
import com.microservice.userservice.dto.ResponseDTO;
import com.microservice.userservice.entity.UserEntity;
import com.microservice.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity getUser(Long id){
        return userRepository.getByUserId(id);

    }

    public ResponseDTO getUserWithDept(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        UserEntity userEntity=getUser(id);

        DepartmentDTO departmentDTO= restTemplate.getForObject("http://localhost:9001/api/department/"+userEntity.getDepartmentId(),
                DepartmentDTO.class);

        responseDTO.setUserEntity(userEntity);
        responseDTO.setDepartmentDTO(departmentDTO);

        return responseDTO;
    }
}
