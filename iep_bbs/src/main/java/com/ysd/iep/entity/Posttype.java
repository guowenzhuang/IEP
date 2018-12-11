package com.ysd.iep.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;


/**
 * 帖子分类关系实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="posttypetb")
public class Posttype {
	
	@Id	//实体类的主键
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'  ")
	private Integer ptId;
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private Post post;  //所属帖子id
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Typetb.class)
	@JoinColumn(name="type_id")	//副表中的外键字段名称
	private Typetb type;	//所属分类id
	

}
