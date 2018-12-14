package com.ysd.iep.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostQuery {
	
	private String typeName; //类型名称
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date replyTime;		//回复时间
	private Integer likeNum;	//点赞数
	private Integer reportNum;  	//举报数
	private String orderBy;		//排序
	private String postTitle;

}
