package com.ysd.iep.entity.dto;

import lombok.Data;

@Data
public class StudentUserDTO {
	private String id;
    private String loginName;
    private String protectEMail;
    private String protectMTel;
    private String card ;//教师工号
    private String photo;//教师头像
    private String sex;//老师性别
}
