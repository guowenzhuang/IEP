package com.ysd.iep.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.social.security.SocialAuthenticationProvider;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class QQProperties {
    private String appId;
    private String appSecret;
    private String providerId="qq";
}
