package com.mhj.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author Peter
 * @version 1.0.0
 * @date 2020-04-09 9:41
 **/
@Data
public class BaseBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;

    public BaseBusinessException() {
    }

    public BaseBusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
