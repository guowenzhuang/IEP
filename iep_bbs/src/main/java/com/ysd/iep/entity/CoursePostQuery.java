package com.ysd.iep.entity;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class CoursePostQuery {
	
	private String typeName; //类型名称
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,pattern = "yyyy-MM-dd HH:mm:ss")
	private String orderBy;		//排序
	
	private Integer courseId;	//课程id
	
	private String userId;	//用户id

}
