package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;

import com.ysd.iep.annotation.ExcelField;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class UsersTeaDTO {
	@ExcelField(showDisplay=true,templaletDisplay = true)
    private String id;
	@ExcelField(value = "用户名",notNull = true)
    private String loginName;
	@ExcelField(value = "邮箱",notNull = false)
    private String protectEMail;
	@ExcelField(value = "手机号",notNull = false)
    private String protectMTel;
	@ExcelField(value = "教师工号",notNull = false)
    private Integer teaNumber;//教师工号
	@ExcelField(value = "头像",showDisplay=true,templaletDisplay = true)
    private String teaPhoto;//教师头像
	@ExcelField(value = "性别",notNull = false)
    private String teaSex;//老师性别
	@ExcelField(value = "所属院系")
    private String teaDepartmentid;//教师所属院系
	//@ExcelField(value = "院系名")
	@ExcelField(value = "院系名",showDisplay=true,templaletDisplay = true)
	private String depName;
    @ExcelField(value = "描述",notNull = false)
    private String teaDescribe;//教师描述
    @ExcelField(value = "教师寄语",notNull = false)
    private String teaTalk;//教师寄语
}
