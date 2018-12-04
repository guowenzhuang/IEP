package com.ysd.iep.config;

import com.ysd.iep.authentication.IepAuthenticationFailHandler;
import com.ysd.iep.authentication.IepAuthenticationSuccessHandler;
import com.ysd.iep.authorize.AuthorizeConfigManager;
import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.social.openid.OpenIdAuthenticationSecurityConfig;
import com.ysd.iep.validate.code.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IepResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private SpringSocialConfigurer iepSocialSecurityConfig;
    @Autowired
    protected IepAuthenticationSuccessHandler iepAuthenticationSuccessHandler;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
    @Autowired
    protected IepAuthenticationFailHandler iepAuthenticationFailHandler;
    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;





    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(iepAuthenticationSuccessHandler)
                .failureHandler(iepAuthenticationFailHandler);

        //验证码配置
        http.apply(validateCodeSecurityConfig)
                .and()
        //短信验证配置
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                //Social过滤器
                .apply(iepSocialSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                //关闭跨站防护
                .csrf().disable();
        authorizeConfigManager.config(http.authorizeRequests());
    }
}
