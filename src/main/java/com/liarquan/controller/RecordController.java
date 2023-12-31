package com.liarquan.controller;


import com.liarquan.ResponseResult;
import com.liarquan.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RecordController {

    @Resource
    RecordService recordService;

    @GetMapping("borrowBook/{bookId}/{userId}")
    public ResponseResult<?> borrowBook(@PathVariable Integer bookId, @PathVariable Integer userId) {
        return recordService.borrowBook(bookId, userId);
    }

    @GetMapping("returnBook/{bookId}/{readerId}")
    public ResponseResult<?> returnBook(@PathVariable Integer bookId, @PathVariable Integer readerId) {
        return recordService.returnBook(bookId, readerId);
    }

    @GetMapping("getRecords/{readerId}")
    public ResponseResult<?> record(@PathVariable Integer readerId) {
        return recordService.getRecords(readerId);
    }

    @GetMapping("getAllRecords")
    public ResponseResult<?> getAllRecords() {
        return recordService.getAllRecords();
    }

}
