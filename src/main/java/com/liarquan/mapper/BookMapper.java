package com.liarquan.mapper;


import com.liarquan.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
                                            where reader_id = #{id} and return_time is null)
                                                    """)
    List<Book> getBorrowedBooksById(Integer id);

    @Select("""
                select * from book where id not in (select book_id
                                                from record
                                                where reader_id = #{id})
            """)
    List<Book> getUnBorrowedBooksById(Integer id);

    @Insert("""
            insert into book(name,author,publish_time,inventory) values(#{name},#{author},#{publishTime},#{inventory})
            """)
    void addBook(Book book);

    @Delete("""
            delete from book where id = #{bookId}
            """)
    void deleteBook(Integer bookId);
}
