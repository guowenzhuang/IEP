package com.ysd.iep.social.impl;

import com.ysd.iep.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

    @Autowired
    private AuthenticationSuccessHandler iepAuthenticationSuccessHandler;


    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
        // 这里设置的其实就是之前  重构用户名密码登录里面实现的 MyAuthenticationSuccessHandler
        socialAuthenticationFilter.setAuthenticationSuccessHandler(iepAuthenticationSuccessHandler);
    }

}
