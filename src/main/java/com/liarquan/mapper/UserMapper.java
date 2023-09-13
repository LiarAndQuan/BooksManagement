package com.liarquan.mapper;


import com.liarquan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("""
                select * from user where username=#{username} and password=#{password}
            """)
    User getUser(User user);

    @Update(
            """
                            update user set name = #{name},password=#{password},gender = #{gender},
                                        phone_number=#{phoneNumber},username=#{username}
                                        where id=#{id}
                    """
    )
    void editMessage(User user);
}
