package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UsersTeaDTO {
    private String id;
    private String loginName;
    private String protectEMail;
    private String protectMTel;
    private Integer teaNumber;//教师工号
    private String teaPhoto;//教师头像
    private String teaSex;//老师性别
    private Integer teaDepartmentid;//教师所属院系
    private String teaDescribe;//教师描述
    private String teaTalk;//教师寄语
}
