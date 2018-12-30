package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UsersStuDTO {
    private String id;
    /**
     * 名称
     */
    private String loginName;
    /**
     * 邮箱
     */
    private String protectEMail;
    /**
     * 手机号
     */
    private String protectMTel;
    /**
     * 学生性别
     */
    private String sex;

    /**
     * 学生头像
     */
    private String photo;

    /**
     * 学生身份证号
     */
    private String card;
    /**
     * 所属班级id
     */
    private String cid;
    private String code;
}
