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
	
	
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CourseReply> replyList;	//回复列表
	
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CoursePosttype> posttypeList; //帖子分类列表

}
