package com.ysd.iep.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity       //使用默认类名
@Table(name = "noticetb")
@Data
public class notice implements Serializable{
	@Id
	@GeneratedValue  //   自动增长列
	@Column(columnDefinition = "int unsigned NOT NULL AUTO_INCREMENT  COMMENT '公告Id'")
	private Integer noId;
	@Column(columnDefinition = "int  NOT NULL DEFAULT 0 COMMENT '课程id(外键)'")
	private Integer noCourid;
	@Column(columnDefinition = "varchar(200) DEFAULT NULL COMMENT '公告内容'")
	private String noConten;
	@Column(columnDefinition = "varchar(100) DEFAULT NULL COMMENT '公告题目'")
	private String noTitle;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL COMMENT '公告时间'")
	private Timestamp noCreattime;
	@Column(columnDefinition="int   NULL comment '备注:预留1'") 
	private Integer Ext1;
	@Column(columnDefinition="varchar(200)   NULL comment '备注:预留2'") 
	private String Ext2;
	
	
}
