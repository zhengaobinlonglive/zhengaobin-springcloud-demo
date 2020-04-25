package com.zhengaobin.springcloud.demo.user.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultEntity implements Serializable {
    private String reason;
    private Integer code;
    private Object result;

    public ResultEntity() {

    }

    public ResultEntity(String reason, Integer code, Object result) {
        this.reason = reason;
        this.code = code;
        this.result = result;
    }

    public static ResultEntity ok(Object result) {
        return new ResultEntity("success", 10001, result);
    }

    public static ResultEntity error() {
        return new ResultEntity("error", 10002, null);
    }

    public static ResultEntity error(Integer code, Object result) {
        return new ResultEntity("error", code, result);
    }
}
