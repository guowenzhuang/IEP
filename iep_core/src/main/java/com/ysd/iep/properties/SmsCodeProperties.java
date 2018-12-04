package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class SmsCodeProperties {
    private int length=6;
    private int expireIn=60;
    private String url;
}
