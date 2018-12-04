package com.ysd.iep.validate.code.sms;

/**
 * 默认短信验证码发送
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        //TODO 默认验证码发送
        System.out.println("向手机"+mobile+"发送短信验证码"+code);
    }
}
