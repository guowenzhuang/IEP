package com.ysd.iep.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class PasswordEncrypt {
    private static BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String encryptPassword(String password){
        String newPassword = passwordEncoder.encode(password);
        return newPassword;
    }
}
