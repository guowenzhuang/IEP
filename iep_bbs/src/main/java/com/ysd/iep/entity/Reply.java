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
	@OrderBy
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

}
