package com.ysd.iep.service;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UserInfo {
    private String id;
    private String name;
    private String password;
    private String isLockout;
    private String protectEMail;
    private String protectMTel;
}
