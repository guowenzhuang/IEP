package com.ysd.iep.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UserInfo implements Serializable {
    private String id;
    private String name;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String isLockout;
    @JsonIgnore
    private String protectEMail;
    @JsonIgnore
    private String protectMTel;
}
