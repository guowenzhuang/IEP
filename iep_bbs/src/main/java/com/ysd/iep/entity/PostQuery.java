package com.ysd.iep.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *  	帖子查询实体类
 * @author mengshaohua
 *
 */
@Data
public class PostQuery {
	
	private String typeName; //类型名称
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,pattern = "yyyy-MM-dd HH:mm:ss")
	private String orderBy;		//排序
	private String postTitle;	//帖子主题
	private String userName;	//发帖人姓名

}
