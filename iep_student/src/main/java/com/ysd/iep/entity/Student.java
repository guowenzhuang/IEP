package com.ysd.iep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="studenttb")
@Data
public class Student {
	@Id
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:学生表主键'  ")
	private String sid;//学生id
	
	@Column(columnDefinition="varchar(2) NOT NULL comment '备注:学生性别'  ")
	private String sex;//学生性别
	
	@Column(columnDefinition="varchar(50) NULL comment '备注:学生头像'  ")
	private String photo;//学生头像
	
	@Column(columnDefinition="varchar(18) NULL comment '备注:学生身份证号'  ")
	private String card;//学生身份证号
	
	@Column(columnDefinition="int NULL comment '备注:所属班级id'  ")
	private Integer cid;//所属班级id
	
	@Column(columnDefinition="varchar(50) NULL comment '备注:用户id' ")
	private String uid;//用户id

}
