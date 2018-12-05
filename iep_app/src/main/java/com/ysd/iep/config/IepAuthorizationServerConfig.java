package com.ysd.iep.config;

import com.ysd.iep.exception.CustomWebResponseExceptionTranslator;
import com.ysd.iep.properties.OAuth2ClientProperties;
import com.ysd.iep.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Configuration
@EnableAuthorizationServer
@Slf4j
public class IepAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private TokenStore tokenStore;
    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;

    public IepAuthorizationServerConfig(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(this.authenticationManager)
                .userDetailsService(userDetailsService);
        if(jwtAccessTokenConverter!=null && jwtTokenEnhancer!=null){
            TokenEnhancerChain enhancerChain=new TokenEnhancerChain();
            List<TokenEnhancer> tokenEnhancers=new ArrayList<>();
            tokenEnhancers.add(jwtTokenEnhancer);
            tokenEnhancers.add(jwtAccessTokenConverter);
            enhancerChain.setTokenEnhancers(tokenEnhancers);
            endpoints
                    .tokenEnhancer(enhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }



    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder inMemory = clients.inMemory();
        OAuth2ClientProperties[] clientsInCustom = securityProperties.getOauth2().getClients();
        for (OAuth2ClientProperties p : clientsInCustom) {
            log.info("clientid={}",p.getClientId());
            log.info("clientSecret={}",p.getClientSecret());
            inMemory.withClient(p.getClientId())
                    .secret(p.getClientSecret())
                    .accessTokenValiditySeconds(p.getAccessTokenValiditySeconds())
                    .refreshTokenValiditySeconds(2592000)
                    .redirectUris("http://example.com", "http://ora.com","http://127.0.0.1:9010/login")
                    .authorizedGrantTypes("refresh_token", "password")
                    .scopes("all", "read", "write");
        }

    }



    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 这里使用什么密码需要 根据上面配置client信息里面的密码类型决定
        // 目前上面配置的是无加密的密码
        security.passwordEncoder(NoOpPasswordEncoder.getInstance())
                //开启判断token是否过期
                .checkTokenAccess("permitAll()");
    }
}
