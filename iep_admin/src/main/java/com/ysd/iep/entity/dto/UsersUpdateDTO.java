package com.ysd.iep.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class UsersUpdateDTO {
    //用户id
    private String id;
    //用户姓名
    private String loginName;
    //用户邮箱
    private String protectEMail;
    //用户手机号
    private String protectMTel;
}
