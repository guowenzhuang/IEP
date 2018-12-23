package com.ysd.iep.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private Boolean success;
    private T message;
    private String remark;

    public Result() {
    }

    public Result(Boolean success, T message) {
        this.success = success;
        this.message = message;
    }

    public static Result<String> success(String url) {
        return new Result<String>()
                .setSuccess(true)
                .setMessage(url);
    }
    public static Result<String> error(String url) {
        return new Result<String>()
                .setSuccess(false)
                .setMessage(url);
    }

}
