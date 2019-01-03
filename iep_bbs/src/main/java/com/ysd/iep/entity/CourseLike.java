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
@Table(name="courseliketb")
public class CourseLike {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer likeId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:用户id' ")
	private String userId;
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = CourseReply.class)
	@JoinColumn(name="reply_id")	//副表中的外键字段名称
	private CourseReply reply; //回复

}
