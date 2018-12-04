package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class BrowserProperties {
    private SessionProperties session = new SessionProperties();
    private String signUpUrl="/iep-signUp.html";
    private String signOutUrl="/demo-logout.html";
    private String loginPage="/iep-login.html";
    private LoginType loginType=LoginType.JSON;
    private int rememberMeSeconds=3600;
}
