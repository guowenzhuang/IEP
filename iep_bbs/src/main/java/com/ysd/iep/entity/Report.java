package com.ysd.iep.entity;

import java.util.List;

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

/**
 * 举报实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="reporttb")
public class Report {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer reportId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:用户id' ")
	private String userId;
	
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Reply.class)
	@JoinColumn(name="reply_id")
	private Reply reply;   //回复
	
	@Column(columnDefinition="varchar(100) NOT NULL comment '备注:举报理由' ")
	private String reportReason;

}
