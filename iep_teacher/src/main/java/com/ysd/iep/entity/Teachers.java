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
	//@GeneratedValue
	@GenericGenerator(name="idGenerator",strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")// 自动增长列
	@Column(columnDefinition="int NOT NULL AUTO_INCREMENT  comment '备注:教师Id'")
	private Integer teaId;//教师Id
	@Column(columnDefinition="varchar(100)  NULL comment '备注:用戶Id(外键)'") 
	private Integer teaUserid;//用戶Id(外键)
	@Column(columnDefinition="int  NULL comment '备注:教师工号'") 
	private Integer teaNumber;//教师工号
	@Column(columnDefinition="varchar(20)  NULL comment '备注:教师头像'") 
	private String teaPhoto;//教师头像
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
