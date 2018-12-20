package com.ysd.iep.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * 用户传输类
 * @author 80795
 * @date 2018/11/12 8:55
 */
@ApiModel("用户传输类")
@Data
@Accessors(chain = true)
public class UsersDTO {
    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("用户名称")
    private String loginName;
    @ApiModelProperty("是否锁定")
    private String isLockout;
    @ApiModelProperty("用户最后登录时间")
    private Timestamp lastLoginTime;
    @ApiModelProperty("密码错误次数")
    private Integer psdWrongTime;
    @ApiModelProperty("锁定时间")
    private Timestamp lockTime;
    @ApiModelProperty("用户邮箱")
    private String protectEMail;
    @ApiModelProperty("用户手机号")
    private String protectMTel;
    @ApiModelProperty("用户创建时间")
    private Timestamp createTime;
}
