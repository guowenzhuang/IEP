package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class OAuth2Properties {
    private String jwtSigningKey="iep";
    private OAuth2ClientProperties[] clients={};
}
