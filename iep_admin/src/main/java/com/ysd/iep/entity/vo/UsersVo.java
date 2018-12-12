package com.ysd.iep.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class UsersVo {
    private String id;
    private String loginName;
    private String isLockout;
    private Timestamp lastLoginTime;
    private Timestamp lockTime;
    private String protectEMail;
    private String protectMTel;
    private Timestamp createTime;
}
