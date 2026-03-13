package com.beevillage.common.response;


import com.beevillage.common.enums.GlobalResultCodeEnum;
import com.beevillage.common.exception.BaseExceptionInterface;
import lombok.Data;

/**
 *
 * @since 2026-01-31 17:56
 * @author Jason Feng
 */
@Data
public class Result<T> {

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    protected Result() {}

    private static <T> Result<T> build(Boolean isSuccess, Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(isSuccess);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        return build(true, GlobalResultCodeEnum.SUCCESS.getCode(), GlobalResultCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> fail(BaseExceptionInterface baseException) {
        return build(false, baseException.getCode(), baseException.getMessage(), null);
    }

    public static <T> Result<T> fail(BaseExceptionInterface baseException, String message) {
        return build(false, baseException.getCode(), message, null);
    }
}
