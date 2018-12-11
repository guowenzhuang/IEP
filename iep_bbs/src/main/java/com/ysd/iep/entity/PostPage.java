package com.ysd.iep.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostPage {
	
	private Integer postId;		//帖子id
	private String postTitle;	//帖子标题
	private String posttypeName;	//帖子类型名称
	private String replyContent;	//帖子内容
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date publicTime;	//发表时间
	private String postIsstick;		//是否置顶
	private String postIsselect;	//是否精选
	private Integer likeNum;	//点赞数
	private Integer replyId;
	private Integer replyBrowse;	//浏览数
	private Integer userId;
	private Integer replyParentid;
	

}
