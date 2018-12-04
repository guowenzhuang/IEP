package com.ysd.iep.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Slf4j
public class IepLogoutSuccessHandler implements LogoutSuccessHandler {

    private String signOutUrl;
    private ObjectMapper objectMapper=new ObjectMapper();

    public IepLogoutSuccessHandler(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("退出成功");

        if(StringUtils.isBlank(signOutUrl)){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        }else{
            response.sendRedirect(signOutUrl);
        }
    }
}
