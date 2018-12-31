package com.ysd.iep.entity.dto;

import com.ysd.iep.annotation.ExcelField;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UsersStuDTO {
    @ExcelField(showDisplay=true,templaletDisplay = true)
    private String id;
    /**
     * 名称
     */
    @ExcelField(value = "用户名",notNull = true)
    private String loginName;
    /**
     * 邮箱
     */
    @ExcelField(value = "邮箱",notNull = false)
    private String protectEMail;
    /**
     * 手机号
     */
    @ExcelField(value = "手机号",notNull = false)
    private String protectMTel;
    /**
     * 学生性别
     */
    @ExcelField(value = "性别",notNull = false)
    private String sex;

    /**
     * 学生头像
     */
    @ExcelField(value = "头像",showDisplay=true,templaletDisplay = true)
    private String photo;

    /**
     * 学生身份证号
     */
    @ExcelField(value = "身份证号",notNull = false)
    private String card;
    /**
     * 所属班级id
     */
    @ExcelField(value = "班级")
    private String cid;

    @ExcelField(value = "班级编号",showDisplay=true,templaletDisplay = true)
    private String code;
}
