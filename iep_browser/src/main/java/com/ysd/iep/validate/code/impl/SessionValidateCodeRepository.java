package com.ysd.iep.validate.code.impl;

import com.ysd.iep.entity.dto.ValidateCode;
import com.ysd.iep.properties.ValidateCodeType;
import com.ysd.iep.validate.code.ValidateCodeProcessor;
import com.ysd.iep.validate.code.ValidateCodeRepository;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {
    /** 操作session的工具类 */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        sessionStrategy.setAttribute(request, getSessionKey(validateCodeType), code);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        String sessionKey = getSessionKey(validateCodeType);
        // 拿到创建 create() 存储到session的code验证码对象
        return (ValidateCode) sessionStrategy.getAttribute(request, sessionKey);
       }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        sessionStrategy.removeAttribute(request, getSessionKey(validateCodeType));
    }
    /**
     * 构建验证码放入session时的key; 在保存的时候也使用该key
     * {@link AbstractValidateCodeProcessor#save(org.springframework.web.context.request.ServletWebRequest, cn.mrcode.imooc.springsecurity.securitycore.validate.code.ValidateCode)}
     * @param validateCodeType
     * @return
     */
    private String getSessionKey(ValidateCodeType validateCodeType) {
        return ValidateCodeProcessor.SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
    }

}
