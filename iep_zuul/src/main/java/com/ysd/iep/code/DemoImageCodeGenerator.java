package com.ysd.iep.code;

import com.ysd.iep.validate.code.ValidateCodeGenerator;
import com.ysd.iep.entity.dto.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
