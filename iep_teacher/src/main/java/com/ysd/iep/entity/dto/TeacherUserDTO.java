package com.ysd.iep.entity.dto;

import lombok.Data;
@Data
public class TeacherUserDTO {
	
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
