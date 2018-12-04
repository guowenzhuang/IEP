package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class ValidateCodeProperties {
    private ImageCodeProperties image=new ImageCodeProperties();
    private SmsCodeProperties sms=new SmsCodeProperties();
}
