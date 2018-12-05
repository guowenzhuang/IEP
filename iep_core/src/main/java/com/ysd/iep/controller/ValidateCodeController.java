package com.ysd.iep.controller;

import com.ysd.iep.validate.code.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 验证码控制器
 *
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RestController
@RequestMapping("/api/oauth")
public class ValidateCodeController {
    @Autowired
   private Map<String, ValidateCodeProcessor> validateCodeProcessor;

    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response,@PathVariable("type") String type) throws Exception {
        validateCodeProcessor.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request,response));
    }


}
