package com.ysd.iep.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 学生学习记录表
 *
 */
@Entity
@Table(name="studentrecordtb")
@Data
public class StudentRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:学习记录表主键'  ")
	private Integer rid;//学习记录id
	
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:学生id'  ")
	private String sid;//学生id
	
	@Column(columnDefinition="int NOT NULL comment '备注:课程id'  ")
	private Integer cid;//课程id
	
	@Column(columnDefinition="int NOT NULL comment '备注:章节id'  ")
	private Integer chaid;//章节id
	
	@Column(columnDefinition="varchar(10) NULL comment '备注:视频观看时间'  ")
	private String watchtime;//视频观看时间
	
	@Column(columnDefinition="int NULL comment '备注:学生学分'  ")
	private Integer credits;//学分
	
	@Column(columnDefinition="datetime NULL comment '备注:学习开始的时间'  ")
	private Date starttime;//学习开始的时间
	
	@Column(columnDefinition="varchar(10) NULL comment '备注：预留字段'  ")
	private String ext1;//预留字段

}
