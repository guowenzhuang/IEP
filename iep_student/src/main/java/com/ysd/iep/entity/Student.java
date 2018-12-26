package com.ysd.iep.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="studenttb")
@Data
public class Student {
	/**
	 * 学生id
	 */
	@Id
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:学生表主键'  ")
	private String sid;

	/**
	 * 学生性别
	 */
	@Column(columnDefinition="varchar(2) NULL comment '备注:学生性别'  ")
	private String sex;

	/**
	 * 学生头像
	 */
	@Column(columnDefinition="varchar(50) NULL comment '备注:学生头像'  ")
	private String photo;

	/**
	 * 学生身份证号
	 */
	@Column(columnDefinition="varchar(18) NULL comment '备注:学生身份证号'  ")
	private String card;
	/**
	 * 所属班级id
	 */
	@Column(columnDefinition="int NULL comment '备注:所属班级id'  ")
	private Integer cid;


	/*@JsonIgnore
	@ManyToMany//多对多关系
	@Cascade(value={CascadeType.ALL}) //级联关系
	@JoinTable(name="student_comment_tb", joinColumns={@JoinColumn(name="sid")}, inverseJoinColumns={@JoinColumn(name="mid")}) 
	@NotFound(action = NotFoundAction.IGNORE) //NotFound : 意思是找不到引用的外键数据时忽略，
	private List<StudentComment> listComment;*/
	

}
