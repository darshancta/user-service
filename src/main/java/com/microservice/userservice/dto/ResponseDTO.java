package com.microservice.userservice.dto;

import com.microservice.userservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private UserEntity userEntity;
    private DepartmentDTO departmentDTO;
}
