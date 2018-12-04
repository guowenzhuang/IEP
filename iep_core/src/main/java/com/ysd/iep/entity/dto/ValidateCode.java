package com.ysd.iep.entity.dto;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 短信验证
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = 75984115995009670L;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode() {
    }
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
