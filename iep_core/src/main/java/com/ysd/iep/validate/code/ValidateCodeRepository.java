package com.ysd.iep.validate.code;

import com.ysd.iep.entity.dto.ValidateCode;
import com.ysd.iep.properties.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码存储仓库接口
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface ValidateCodeRepository {
    /**
     * 保存验证码
     * @param request
     * @param code
     * @param validateCodeType
     */
    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

    /**
     * 获取验证码
     * @param request
     * @param validateCodeType
     * @return
     */
    ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

    /**
     * 移除验证码
     * @param request
     * @param validateCodeType
     */
    void remove(ServletWebRequest request, ValidateCodeType validateCodeType);
}
