package com.ysd.iep.entity.dto;

import javax.persistence.Column;

import lombok.Data;
@Data
public class TeacherAddDTO {

	private String teaId;//教师Id
	private Integer teaNumber;//教师工号
	private String teaPhoto;//教师头像
	private String teaSex;//老师性别
	private String teaDepartmentid;//教师所属院系
	private String teaDescribe;//教师描述
}
