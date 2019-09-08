package com.gahon.sso.client.util;

/**
 * @author Gahon
 * @date 2019/9/4
 */
public class ResultGenerate {

    public static Result success() {
        return Result.SUCCESS;
    }

    public static <T> Result success(T data) {
        return new Result<>(data);
    }

    public static Result fail() {
        return Result.FAIL;
    }

    public static Result fail(String msg) {
        return new Result<>(Result.FAIL_CODE, msg);
    }

    public static Result fail(int code, String msg) {
        return new Result<>(code, msg);
    }

}

