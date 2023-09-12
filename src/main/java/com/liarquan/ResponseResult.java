package com.liarquan;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Data
public class ResponseResult<T> implements Serializable {

    private Integer code;
    private String message;
    @Getter
    private T data;

    public ResponseResult() {
        this.code = 200;
        this.message = "成功";
    }

    public static ResponseResult<?> okResult(Object data) {
        ResponseResult<Object> result = new ResponseResult<>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public void setData(T data) {
        this.data = data;
    }
}
