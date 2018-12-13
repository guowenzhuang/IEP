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
	@Column(columnDefinition="timestamp NOT NULL comment '备注:回复时间' ")
	private Timestamp replyTime;
	@Column(columnDefinition="int DEFAULT 0 NOT NULL comment '备注:浏览数' ")
	private Integer replyBrowse;
	@Column(columnDefinition="int NOT NULL comment '备注:回复人id' ")
	private Integer userId;
	@Column(columnDefinition="int NOT NULL comment '备注:回复的评论id' ")
	private Integer replyParentid;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:点赞数' ")
	private Integer replyLikenum;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:举报数' ")
	private Integer replyReportnum;
	
	@Transient
	private Integer postId;
	@Transient
	private String postTitle;
	@Transient
	private String postIsstick;
	@Transient
	private String postIsselect;
	
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
	
	
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyTime=" + replyTime
				+ ", replyBrowse=" + replyBrowse + ", userId=" + userId + ", replyParentid=" + replyParentid
				+ ", replyLikenum=" + replyLikenum + ", replyReportnum=" + replyReportnum + ", postTitle=" + postTitle
				+ ", postIsstick=" + postIsstick + ", postIsselect=" + postIsselect + ", post="  + ", likeList="
				+ likeList + ", reportList=" + reportList + "]";
	}

}
