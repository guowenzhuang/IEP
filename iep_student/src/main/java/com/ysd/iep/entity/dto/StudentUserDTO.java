package com.ysd.iep.entity.dto;

import lombok.Data;

@Data
public class StudentUserDTO {
	private String id;
    private String loginName;
    private String protectEMail;
    private String protectMTel;
    private String card ;//学生工号
    private String photo;//学生头像
    private String sex;//学生性别
    private Integer credits;
}
