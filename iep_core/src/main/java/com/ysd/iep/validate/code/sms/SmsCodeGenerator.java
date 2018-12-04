package com.ysd.iep.validate.code.sms;

import com.ysd.iep.entity.dto.ValidateCode;
import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.validate.code.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * 图片验证码生成
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Component("smsCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode  generate(ServletWebRequest request) {
        String code= RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }


}
