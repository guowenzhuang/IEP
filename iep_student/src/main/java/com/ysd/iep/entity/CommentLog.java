package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.persistence.*;

/**
 * 点赞记录表实体类
 * @author mengshaohua
 *
 */
@Data
@Entity
@Table(name="commentlog")
public class CommentLog {
	@Id
	@GeneratedValue	//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键' ")
	private Integer commentLogId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:用户id' ")
	private String sid;
	private Integer mid;
	

}
