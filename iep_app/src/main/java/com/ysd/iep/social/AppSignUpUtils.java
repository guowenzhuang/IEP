package com.ysd.iep.social;

import com.sun.deploy.association.utility.AppConstants;
import com.ysd.iep.exception.AppsecretException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import sun.applet.AppletSecurityException;

import java.util.concurrent.TimeUnit;

@Component
public class AppSignUpUtils {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    // 目前为止都是自动配置的，直接获取即可
    @Autowired
    private UsersConnectionRepository usersConnectionRepository;
    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    public void saveConnection(ServletWebRequest request, ConnectionData connectionData) {
        redisTemplate.opsForValue().set(getKey(request), connectionData,10, TimeUnit.MINUTES);
    }
    public void doPostSignUp(String userId, ServletWebRequest request) {
        String key = getKey(request);
        if(!redisTemplate.hasKey(key)){
            throw new AppletSecurityException("无法找到缓存的用户社交账号信息");
        }
        ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);
        usersConnectionRepository.createConnectionRepository(userId).addConnection(getConnection(connectionFactoryLocator, connectionData));
        redisTemplate.delete(key);
    }

    public Connection<?> getConnection(ConnectionFactoryLocator connectionFactoryLocator, ConnectionData connectionData) {
        return connectionFactoryLocator.getConnectionFactory(connectionData.getProviderId()).createConnection(connectionData);
    }

    private String getKey(ServletWebRequest request) {
        String deviceId=request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new AppsecretException("设备id参数不能为空");
        }
        return "iep:security:social.connect." + deviceId;
    }
}
