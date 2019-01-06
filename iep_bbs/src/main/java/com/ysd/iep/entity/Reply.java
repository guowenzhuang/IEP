package com.ysd.iep.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

/**
 * 回复实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="replytb")
public class Reply {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer replyId;
	@Column(columnDefinition="text NOT NULL comment '备注:回复内容' ")
	private String replyContent;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(columnDefinition="timestamp NOT NULL comment '备注:回复时间' ")
	private Timestamp replyTime;
	@Column(columnDefinition="int DEFAULT 0 NOT NULL comment '备注:浏览数' ")
	private Integer replyBrowse;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:回复人id' ")
	private String userId;
	@Column(columnDefinition="int NOT NULL comment '备注:回复的评论id' ")
	private Integer replyParentid;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:点赞数' ")
	private Integer replyLikenum;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:举报数' ")
	private Integer replyReportnum;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:回复数' ")
	private Integer replyNum;
	@Column(columnDefinition="tinyint(1) DEFAULT 0  comment '备注:是否被删除' ")
	private Boolean isDelete;
	
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")
	private Post post; //所属帖子id
	
	@JsonIgnore
	@OneToMany(mappedBy="reply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Like> likeList; //点赞记录列表
	
	@JsonIgnore
	@OneToMany(mappedBy="reply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Report> reportList;  //举报记录列表
	
	@Transient
	private Boolean isReply;	//判断回复的是帖子或是回复
	@Transient
	private Boolean isLike;		//判断用户是否点赞
	@Transient
	private Boolean isReport;	//判断用户是否举报
	
	@Transient
	private Object replyUsername;	//回复人姓名
	@Transient
	private Object byUsername;	//被回复人姓名
	@Transient
	private Boolean isMy;

}
