package com.ysd.iep.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.sql.Timestamp;

@Data
public class PostDTO {

	private Integer postId;
	private String postTitle;
	private boolean postIsstick;
	

	
	private String posttypeName;  //帖子分类名称
	private Integer replyId;
	private String replyContent;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp replyTime;
	private Integer replyBrowse;
	private String userId;
	private Integer replyParentid;
	private Integer replyLikenum;
	private Integer replyReportnum;
	private Object userName;
	
	
	
}