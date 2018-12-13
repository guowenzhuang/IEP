package com.ysd.iep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity       //使用默认类名
@Table(name = "teachertb")
@Data
public class Teachers  implements Serializable{
	@Id
	@Column(name = "teaId", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String teaId;//教师Id
	@Column(columnDefinition="int  NULL comment '备注:教师工号'") 
	private Integer teaNumber;//教师工号
	@Column(columnDefinition="varchar(20)  NULL comment '备注:教师头像'") 
	private String teaPhoto;//教师头像
	@Column(columnDefinition="char(2)   NULL comment '备注:老师性别'") 
	private String teaSex;//老师性别
	@Column(columnDefinition="int   NULL comment '备注:教师所属院系'") 
	private Integer teaDepartmentid;//教师所属院系
	@Column(columnDefinition="varchar(200)   NULL comment '备注:教师描述'") 
	private String teaDescribe;//教师描述
	@Column(columnDefinition="varchar(200)   NULL comment '备注:教师寄语'") 
	private String teaTalk;//教师寄语
	@Column(columnDefinition="int   NULL comment '备注:预留1'") 
	private Integer Ext1;
	@Column(columnDefinition="varchar(200)   NULL comment '备注:预留2'") 
	private String Ext2;
	

}
