package com.liarquan.mapper;


import com.liarquan.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("""
            select * from book where inventory>0;
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
                                                where reader_id = #{id} and return_time is null)
                                                and inventory>0
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

    @Update("""
            update book set inventory = inventory+1 where id=#{bookId}
            """)
    void increaseInventory(Integer bookId);

    @Update("""
            update book set inventory=inventory-1 where  id = #{bookId}
            """)
    void decreaseInventory(Integer bookId);

}
