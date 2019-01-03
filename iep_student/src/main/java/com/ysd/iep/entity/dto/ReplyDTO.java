package com.ysd.iep.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
public class ReplyDTO {
	private Integer replyId;
	private String replyContent;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp replyTime;
	private Integer replyBrowse;
	private String userId;
	private Integer replyParentid;
	private Integer replyLikenum;
	private Integer replyReportnum;
	private Boolean isDelete;

	private Boolean isReply;	//判断回复的是帖子或是回复
	private Boolean isLike;		//判断用户是否点赞
	private Boolean isReport;	//判断用户是否举报
	
	private Object replyUsername;	//回复人姓名
	private Object byUsername;	//被回复人姓名

}
