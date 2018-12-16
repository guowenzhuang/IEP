package com.ysd.iep.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity         //使用默认类名
@Table(name = "chaptertb")
@Data
public class Chapters implements Serializable{
	@Id
	@GeneratedValue// 自动增长列
	@Column(columnDefinition = "int unsigned AUTO_INCREMENT NOT NULL  COMMENT '章节Id'")
	private Integer chaId;
	@Column(columnDefinition = "int NOT NULL DEFAULT 0 COMMENT '父模块Id'")
	private Integer chaParentid;
	@Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '章节名称'")
	private String chaName;
	@Column(columnDefinition="varchar(100)  NULL comment '备注:章节视频地址'")
	private String chaViurl;
	@Column(columnDefinition="varchar(50)  NULL comment '备注:章节ppt地址'")
	private String chaPpturl;
	@Column(columnDefinition="varchar(100)  NULL comment '备注:章节文档地址'")
	private String chaDocurl;//章节文档地址
	@Column(columnDefinition="int null comment '备注:课程id(外建)'")
	private Integer chaCourid;
	@Column(columnDefinition="varchar(50)  NULL comment '备注:视频时长'")
	private String chaTime;//视频时长
	@Transient
//	@JsonInclude(Include.NON_NULL)
	// 如果该属性为NULL则不参与序列化
	private List<Chapters> children;
	@Column(columnDefinition="int NULL comment '备注:预留1'") 
	private Integer Ext1;
	@Column(columnDefinition="varchar(200)   NULL comment '备注:预留2'") 
	private String Ext2;
}
