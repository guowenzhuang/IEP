package com.ysd.iep.config;

import com.ysd.iep.authorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Component
public class BbsAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers("/post/getAllPost"
                		,"/post/userIsPost"
                		,"/type/*"
                		,"/reply/getReplyByPostId"
                		,"/reply/updateBrowse"
                		,"/reply/updateBrowse"
                		,"/report/*"
                		,"/coursepost/*"
                		,"/coursetype/*"
                		,"/coursereply/*")
                .permitAll();
    }
}
