package com.liarquan.service;


import com.liarquan.ResponseResult;
import com.liarquan.mapper.RecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class RecordService {

    @Resource
    RecordMapper recordMapper;


    public ResponseResult<?> borrowBook(Integer bookId, Integer userId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        recordMapper.borrowBook(bookId, userId, localDateTime);
        return ResponseResult.okResult(null);
    }
}
