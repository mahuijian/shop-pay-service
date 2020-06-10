package com.mhj.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCodeEnum {

    SUCCESS(200, "操作成功"),
    PARAM_ERROR(400, "参数不能为空"),
    NOT_LOGIN(401, "未登录"),
    SIGN_ERROR(403, "签名错误"),
    FAIL(500, "操作失败"),

    USER_FOUND(10000, "用户已经存在"),
    USER_NOT_FOUND(10001, "用户不存在"),
    PWD_ERR(10002, "密码错误"),
    ;

    private Integer code;
    private String message;
}