package com.liarquan.mapper;


import com.liarquan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("""
                select * from user where username=#{username} and password=#{password}
            """)
    User getUser(User user);
}
