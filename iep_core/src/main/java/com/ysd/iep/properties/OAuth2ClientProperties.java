package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class OAuth2ClientProperties {
    private String clientId;
    private String clientSecret;
    private int accessTokenValiditySeconds=9000;
}
