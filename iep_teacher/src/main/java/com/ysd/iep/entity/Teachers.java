package com.ysd.iep.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity       //使用默认类名
@Table(name = "teachertb")
@Data
public class Teachers  implements Serializable{
	@Id
	@Column(name = "teaId", nullable = false, length = 100)
	private String teaId;//教师Id
	@Column(columnDefinition="int  NULL comment '备注:教师工号'")
	private Integer teaNumber;//教师工号
	@Column(columnDefinition="varchar(200)  NULL comment '备注:教师头像'")
	private String teaPhoto;//教师头像
	@Column(columnDefinition="char(2)   NULL comment '备注:老师性别'")
	private String teaSex;//老师性别
	@Column(columnDefinition="int   NULL comment '备注:教师所属院系'")
	private String teaDepartmentid;//教师所属院系
	@Column(columnDefinition="varchar(200)   NULL comment '备注:教师描述'")
	private String teaDescribe;//教师描述
	@Column(columnDefinition="int   NULL comment '备注:预留1'")
	private Integer Ext1;
	@Column(columnDefinition="varchar(200)   NULL comment '备注:预留2'")
	private String Ext2;






}
