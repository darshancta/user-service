package com.microservice.userservice.controller;

import com.microservice.userservice.entity.UserEntity;
import com.microservice.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
      log.info("inside user service saving data ");
      return  userService.saveUser(userEntity);

    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id){
        log.info("inside user service get data");
        return  userService.getUser(id);

    }
}
