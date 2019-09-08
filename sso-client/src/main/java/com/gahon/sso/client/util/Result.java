package com.gahon.sso.client.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * common return
 *
 * @param <T>
 * @author Gahon
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final Result<String> SUCCESS = new Result<>(null);
    public static final Result<String> FAIL = new Result<>(FAIL_CODE, null);

    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }
}
