package com.ysd.iep.validate.code;

import com.ysd.iep.entity.dto.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
