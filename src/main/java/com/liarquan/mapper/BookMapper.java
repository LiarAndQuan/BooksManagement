package com.liarquan.mapper;


import com.liarquan.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("""
            select * from book
            """)
    List<Book> getAllBooks();

    @Select("""
                select * from book where id in (select book_id
                                                from record
                                                where reader_id = #{id})
            """)
    List<Book> getBorrowedBooksById(Integer id);

    @Select("""
                select * from book where id not in (select book_id
                                                from record
                                                where reader_id = #{id})
            """)
    List<Book> getUnBorrowedBooksById(Integer id);
}
