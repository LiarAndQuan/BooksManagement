package com.liarquan.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface RecordMapper {

    @Insert("""
                insert into record(reader_id,book_id,borrow_time) values (#{bookId},#{userId},#{localDateTime});
            """)
    void borrowBook(Integer bookId, Integer userId, LocalDateTime localDateTime);
}
