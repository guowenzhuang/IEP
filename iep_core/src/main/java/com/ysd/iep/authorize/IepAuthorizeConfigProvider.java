package com.ysd.iep.authorize;

import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.validate.code.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Component
public class IepAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers(
                        "/api/oauth/regist",
                        "/api/oauth/userRegist",
                        "/social/signUp",
                        "/oauth/check_token",
                        "/api/student/**",
                        "/api/bbs/**",
                        "/swagger-ui.html",
                         "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**")
                .permitAll();
                //.antMatchers("/student/*").hasRole("学生")
    }
}
