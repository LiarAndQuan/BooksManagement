package com.liarquan.controller;


import com.liarquan.ResponseResult;
import com.liarquan.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("getAllBooks")
    public ResponseResult<?> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("borrowedBooks/{id}")
    public ResponseResult<?> getBorrowedBooksById(@PathVariable Integer id) {
        return bookService.getBorrowedBooksById(id);
    }

    @GetMapping("unBorrowedBooks/{id}")
    public ResponseResult<?> getUnBorrowedBooksById(@PathVariable Integer id) {
        return bookService.getUnBorrowedBooksById(id);
    }


}
