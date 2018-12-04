package com.ysd.iep.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
