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
 *   学生报名表
 * @author ASUS
 *
 */
@Entity
@Table(name="studentparttb")
@Data
public class StudentPart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:报名表增长主键'  ")
	private Integer spid;//报名表id
	
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:学生id'  ")
	private String  sid;//学生id
	
	@Column(columnDefinition="int NOT NULL comment '备注:课程id'  ")
	private Integer cid;//课程id
	
	@Column(columnDefinition="datetime NOT NULL comment '备注:报名时间'  ")
	private Date parttime;//报名时间
	

}
