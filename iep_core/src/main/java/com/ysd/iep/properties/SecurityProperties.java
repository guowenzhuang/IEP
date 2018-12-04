package com.ysd.iep.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@ConfigurationProperties(prefix = "iep.security")
@Data
public class SecurityProperties {
    private BrowserProperties browser=new BrowserProperties();
    private ValidateCodeProperties code=new ValidateCodeProperties();
    private SocialProperties social=new SocialProperties();
    private OAuth2Properties oauth2=new OAuth2Properties();
}
