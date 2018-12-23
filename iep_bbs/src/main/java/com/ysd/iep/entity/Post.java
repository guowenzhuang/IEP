package com.ysd.iep.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
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

import lombok.Data;

/**
 * 帖子实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="posttb")
public class Post {

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
	private List<Reply> replyList;	//回复列表
	
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Posttype> posttypeList; //帖子分类列表
	
	@Transient
	private String posttypeName;  //帖子分类名称
	@Transient
	private Integer replyId;
	@Transient
	private String replyContent;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Transient
	private Timestamp replyTime;
	@Transient
	private Integer replyBrowse;
	@Transient
	private String userId;
	@Transient
	private Integer replyParentid;
	@Transient
	private Integer replyLikenum;
	@Transient
	private Integer replyReportnum;
	@Transient
	private Object userName;
	
	
	
}
