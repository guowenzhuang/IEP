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
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        SecurityConstants.DEFAULT_SESSION_INVALID_URL,
                        SecurityConstants.DEFAULT_SESSION_INVALID_URL + ".html",
                        securityProperties.getBrowser().getSignOutUrl(),
                        "/api/oauth/regist",
                        "/api/oauth/userRegist",
                        "/social/signUp",
                        "/login",
                        "/oauth/check_token",
                        "/hello",
                        "/api/student/**",
                        "/api/bbs/**",
                        "/swagger-ui.html",
                         "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/depart/get",
                        "/depart/getTop7")
                .permitAll();
                //.antMatchers("/student/*").hasRole("学生")
    }
}
