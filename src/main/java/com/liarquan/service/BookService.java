package com.liarquan.service;


import com.liarquan.ResponseResult;
import com.liarquan.entity.Book;
import com.liarquan.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    BookMapper bookMapper;

    public ResponseResult<?> getAllBooks() {
        List<Book> books = bookMapper.getAllBooks();
        return ResponseResult.okResult(books);
    }

    public ResponseResult<?> getBorrowedBooksById(Integer id) {
        List<Book> books = bookMapper.getBorrowedBooksById(id);
        return ResponseResult.okResult(books);
    }

    public ResponseResult<?> getUnBorrowedBooksById(Integer id) {
        List<Book> books = bookMapper.getUnBorrowedBooksById(id);
        return ResponseResult.okResult(books);
    }

    public ResponseResult<?> addBook(Book book) {
        bookMapper.addBook(book);
        return ResponseResult.okResult(null);
    }

    public ResponseResult<?> deleteBook(Integer bookId) {
        bookMapper.deleteBook(bookId);
        return ResponseResult.okResult(null);
    }
}
