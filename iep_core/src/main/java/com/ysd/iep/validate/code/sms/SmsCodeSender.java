package com.ysd.iep.validate.code.sms;

/**
 * 短信验证码
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface SmsCodeSender {
    /**
     * 发送验证码
     * @param mobile
     * @param code
     */
    void send(String mobile,String code);
}
