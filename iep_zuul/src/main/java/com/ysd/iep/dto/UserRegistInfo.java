package com.ysd.iep.dto;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UserRegistInfo {
    private String name;
    private String password;
    private String protectEMail;
    private String protectMTel;
}
