package com.liarquan.service;


import com.liarquan.ResponseResult;
import com.liarquan.mapper.BookMapper;
import com.liarquan.mapper.RecordMapper;
import com.liarquan.vo.RecordVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    @Resource
    RecordMapper recordMapper;

    @Resource
    BookMapper bookMapper;


    public ResponseResult<?> borrowBook(Integer bookId, Integer userId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        recordMapper.borrowBook(bookId, userId, localDateTime);
        bookMapper.decreaseInventory(bookId);
        return ResponseResult.okResult(null);
    }

    public ResponseResult<?> returnBook(Integer bookId, Integer readerId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        recordMapper.returnBook(bookId, readerId, localDateTime);
        bookMapper.increaseInventory(bookId);
        return ResponseResult.okResult(null);
    }

    public ResponseResult<?> getRecords(Integer readerId) {
        List<RecordVo> recordVos = recordMapper.getRecords(readerId);
        return ResponseResult.okResult(recordVos);
    }

    public ResponseResult<?> getAllRecords() {
        List<RecordVo> recordVos = recordMapper.getAllRecords();
        return ResponseResult.okResult(recordVos);
    }
}
