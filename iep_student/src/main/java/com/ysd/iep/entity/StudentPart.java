package com.ysd.iep.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:报名表增长主键'  ")
	private Integer spid;//报名表id
	
	private Integer  sid;//学生id
	
	private Integer cid;//课程id
	
	private Date parttime;//报名时间
	

}
