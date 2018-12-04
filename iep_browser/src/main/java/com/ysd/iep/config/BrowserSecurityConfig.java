package com.ysd.iep.config;

import com.ysd.iep.authentication.AbstractChannelSecurityConfig;
import com.ysd.iep.authentication.IepAuthenticationFailHandler;
import com.ysd.iep.authentication.IepAuthenticationSuccessHandler;
import com.ysd.iep.authorize.AuthorizeConfigManager;
import com.ysd.iep.logout.IepLogoutSuccessHandler;
import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.validate.code.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private IepAuthenticationSuccessHandler iepAuthenticationSuccessHandler;
    @Autowired
    private IepAuthenticationFailHandler iepAuthenticationFailHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;


    @Qualifier("myUserDetailsService")
    @Autowired(required = false)
    private UserDetailsService userDetailsService;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
    @Autowired
    private SpringSocialConfigurer iepSocialSecurityConfig;
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //创建表 第一次需要 重复创建会报错
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        applyPasswordAuthenticationConfig(http);
        //验证码配置
        http.apply(validateCodeSecurityConfig)
                .and()
                //短信验证配置
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                //Social过滤器
                .apply(iepSocialSecurityConfig)
                .and()
                //记住我功能
                .rememberMe()
                //token Repository
                .tokenRepository(persistentTokenRepository())
                //设置秒数
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                //用户认证
                .userDetailsService(userDetailsService)
                .and()
                //session配置
                .sessionManagement()
                /**
                 * session无效处理
                 */
                .invalidSessionStrategy(invalidSessionStrategy)
                /**
                 * 最大session数量
                 */
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                /**
                 * 是否不允许重复登录 true:不允许重复登录  false:把之前的顶掉
                 */
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                /**
                 * session期望值满处理
                 */
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
                //退出配置
                .logout()
                //退出路径
                .logoutUrl("/signOut")
                //退出成功跳转路径
                //.logoutSuccessUrl("iep-logout.html")
                //出成功跳转Handler 可以做些额外的处理 与logoutSuccessUrl 配置互斥
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
                //关闭跨站防护
                .csrf().disable();
        authorizeConfigManager.config(http.authorizeRequests());

    }


}
