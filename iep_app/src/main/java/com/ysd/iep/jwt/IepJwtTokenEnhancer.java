package com.ysd.iep.jwt;

import com.ysd.iep.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class IepJwtTokenEnhancer implements TokenEnhancer {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String,Object> info=new HashMap<>();
        String name=oAuth2Authentication.getName();
        UserInfo userInfo= (UserInfo) redisTemplate.opsForValue().get("login_"+name);
        info.put("info",userInfo);
        Collection<GrantedAuthority> authorities= oAuth2Authentication.getAuthorities();
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
