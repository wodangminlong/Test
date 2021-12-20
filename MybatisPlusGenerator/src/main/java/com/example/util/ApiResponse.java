package com.example.util;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * uniform return type
 *
 * @author dml
 * @date 2020/06/26 15:21
 */
@Data
public class ApiResponse implements Serializable {

    private int code;
    private String msg;
    private transient Object data;
    private long timestamp;

    public ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }

    private ApiResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }


    public static ApiResponse success() {
        return new ApiResponse(ApiErrorCode.SUCCESS.getCode(), ApiErrorCode.SUCCESS.getMsg());
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(ApiErrorCode.SUCCESS.getCode(), ApiErrorCode.SUCCESS.getMsg(), JSON.toJSONString(data));
    }

    public static ApiResponse error() {
        return new ApiResponse(ApiErrorCode.SYSTEM_ERROR.getCode(), ApiErrorCode.SYSTEM_ERROR.getMsg());
    }

    public static ApiResponse error(ApiErrorCode apiErrorCode) {
        return new ApiResponse(apiErrorCode.getCode(), apiErrorCode.getMsg());
    }

    public static ApiResponse error(ApiErrorCode apiErrorCode, String result) {
        return new ApiResponse(apiErrorCode.getCode(), apiErrorCode.getMsg() + result);
    }

    @Override
    public String toString() {
        return "{code:" + this.getCode() + ", msg:" + this.getMsg() + ", data:" + this.getData() + ", timestamp:" + this.getTimestamp() +"}";
    }

}
