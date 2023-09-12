package com.liarquan.service;


import com.liarquan.ResponseResult;
import com.liarquan.entity.User;
import com.liarquan.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public ResponseResult<?> getUser(User user) {
        User userDetail = userMapper.getUser(user);
        if (userDetail == null) {
            ResponseResult<User> result = new ResponseResult<>();
            result.setData(null);
            result.setCode(400);
            result.setMessage("用户名不存在或密码错误");
            return result;
        }
        return ResponseResult.okResult(userDetail);
    }
}
