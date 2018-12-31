package com.ysd.iep.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 课程讨论区帖子实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="courseposttb")
public class CoursePost {
	
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer postId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:帖子标题' ")
	private String postTitle;
	@Column(columnDefinition="tinyint(1) DEFAULT 0  NOT NULL comment '备注:是否置顶' ")
	private boolean postIsstick;
	@Column(columnDefinition="int DEFAULT 0 comment '备注:回复数' ")
	private Integer replyNum;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CourseReply> replyList;	//回复列表
	
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CoursePosttype> posttypeList; //帖子分类列表
	
	@Transient
	private String replyContent;
	@Transient
	private Integer replyId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Transient
	private Timestamp replyTime;
	@Transient
	private Integer replyBrowse;
	@Transient
	private Integer replyLikenum;
	@Transient
	private Integer replyReportnum;
	@Transient
	private Integer courseId;
	@Transient
	private String userId;
	@Transient
	private Object userName;

}
