package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.List;

@Data
public class Chapters{
	private Integer chaId;
	private Integer chaParentid;
	private String chaName;
	private String chaPpturl;
	private String chaDocurl;
	private Integer chaCourid;
	private String chaType;
	private String chaViurl;
	private String chaTime;//视频时长
	private String chalastModified;
	private String chaSize ;
	private String icon="el-icon-arrow-up";
	private Double watch;
	//学习进度
	private Double progress;
	private List<Chapters> children;
	private Integer Ext1;
	private String Ext2;
}