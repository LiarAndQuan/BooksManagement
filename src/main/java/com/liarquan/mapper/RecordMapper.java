package com.liarquan.mapper;


import com.liarquan.vo.RecordVo;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RecordMapper {

    @Insert("""
                insert into record(reader_id,book_id,borrow_time) values (#{userId},#{bookId},#{localDateTime});
            """)
    void borrowBook(@Param("bookId") Integer bookId, @Param("userId") Integer userId, @Param("localDateTime") LocalDateTime localDateTime);


    @Update("""   
                update record set return_time=#{localDateTime} where book_id=#{bookId} and reader_id=#{readerId}
            """)
    void returnBook(@Param("bookId") Integer bookId, @Param("readerId") Integer readerId, @Param("localDateTime") LocalDateTime localDateTime);


    @Select("""
                select user.name as 'userName', book.name as 'bookName', return_time, borrow_time
                                                                             from record
                                                                                      join user on user.id = record.reader_id
                                                                                      join book on book.id = record.book_id
                                                                             where user.id = #{readerId}
            """)
    List<RecordVo> getRecords(Integer readerId);

    @Select("""
                select user.name as 'userName', book.name as 'bookName', return_time, borrow_time
                                                                             from record
                                                                                      join user on user.id = record.reader_id
                                                                                      join book on book.id = record.book_id
                                                                             
            """)
    List<RecordVo> getAllRecords();
}
