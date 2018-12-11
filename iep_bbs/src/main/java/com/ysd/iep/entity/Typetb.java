package com.ysd.iep.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 帖子分类实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="typetb")
public class Typetb {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer typeId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:类型名称' ")
	private String typeName;
	@Column(columnDefinition="varchar(100) NULL comment '备注:类型描述' ")
	private String typeDescribe;
	
	@JsonIgnore
	@OneToMany(mappedBy="type",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Posttype> posttypeList; //帖子分类列表
	
}
