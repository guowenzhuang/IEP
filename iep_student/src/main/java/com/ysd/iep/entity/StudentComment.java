package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 *  课程评价表
 */
@Entity
@Table(name="commenttb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:评价表主键'  ")
	private Integer mid;//评论表id
	
	@Column(columnDefinition="int NOT NULL comment '备注:课程id'  ")
	private Integer  cid;//课程id
	
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:学生id'  ")
	private String sid;//学生id
	
	@Column(columnDefinition="varchar(100) NOT NULL comment '备注:评价内容'  ")
	private String content;//评价内容
	
	@Column(columnDefinition="datetime NOT NULL comment '备注:评价时间'  ")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date mtime;//评价时间
	
	@Column(columnDefinition="int NULL comment '备注:点赞数'  ")
	private Integer praise;//点赞数
	
	@Column(columnDefinition="varchar(10) NULL comment '备注：预留字段'  ")
	private String ext1;//预留字段

	@Transient
	private Boolean isLike;		//判断用户是否点赞

}
