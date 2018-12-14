package com.ysd.iep.entity;

import java.util.List;

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
 * 点赞记录表实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="liketb")
public class Like {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer likeId;
	@Column(columnDefinition="int NOT NULL comment '备注:用户id' ")
	private Integer userId;
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Reply.class)
	@JoinColumn(name="reply_id")	//副表中的外键字段名称
	private Reply reply; //回复
	

}
