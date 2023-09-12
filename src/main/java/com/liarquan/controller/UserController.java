package com.liarquan.controller;


import com.liarquan.ResponseResult;
import com.liarquan.entity.User;
import com.liarquan.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("login")
    public ResponseResult<?> login(@RequestBody User user) {
        return userService.getUser(user);
    }
}
