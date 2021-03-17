package com.lyx.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDto<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public ResponseDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDto() {
    }

    public static <T> ResponseDto<T> getSuccessResponseDto(T data) {
        return new ResponseDto<>("000","操作成功",data);
    }

    public static <T> ResponseDto<T> getFailResponseDto(T data) {
        return new ResponseDto<>("406","操作失败",data);
    }
}
