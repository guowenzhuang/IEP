package com.ysd.iep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
@Entity
@Table(name="courseposttypetb")
public class CoursePosttype {
	@Id	//实体类的主键
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'  ")
	private Integer ptId;
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = CoursePost.class)
	@JoinColumn(name="post_id")	//副表中的外键字段名称
	private CoursePost post;  //所属帖子id
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = CourseType.class)
	@JoinColumn(name="type_id")	//副表中的外键字段名称
	private CourseType type;	//所属分类id

}
