package com.ysd.iep.entity.elk;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
@Document(indexName = "course",type="doc")
@Data
public class Course implements Serializable{
	@Id
	private Integer courId;  //课程ID

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courName;//课程名称

	@Field(type = FieldType.Keyword)
	private String courTeaid;//教师id

	@Field(type = FieldType.Keyword)
	private String courPicurl;//课程图片url

	@Field(type = FieldType.Double)
	private Double courPrice;//课程价格

	@Field(type = FieldType.Double)
	private Double courNocount;//课程优惠价格

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courContent;//课程描述

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courDetails;//课程详情

	@Field(type=FieldType.Integer)
	private Integer courPageview;//浏览量

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courScore;//评分标准

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courTarget;//课程目标

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courResources;//参考资料

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String courPropaedeutics;//预备知识

	@Field(type = FieldType.Keyword)
	private String courIsputaway;//是否上架

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String courOpentime;//开课时间

	@Field(type = FieldType.Keyword)
	private String courClasshour;//学时

	@Field(type = FieldType.Integer)
	private Integer courCommentcount;//课程评价数量

	@Field(type = FieldType.Integer)
	private Integer courStudypeople;//报名人数

	@Field(type = FieldType.Integer)
	private Integer courMark;//学分

	@Field(type = FieldType.Integer)
	private Integer Ext1;
	@Field(type = FieldType.Keyword)
	private String Ext2;
}
	
	
	
	
	
	