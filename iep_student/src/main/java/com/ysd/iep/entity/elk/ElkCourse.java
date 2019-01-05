package com.ysd.iep.entity.elk;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

@Document(indexName = "course",type="_doc")
@Data
public class ElkCourse {
	@Id
	private Integer cour_id;  //课程ID

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_name;//课程名称

	@Field(type = FieldType.Keyword)
	private String cour_teaid;//教师id

	@Field(type = FieldType.Keyword)
	private String cour_picurl;//课程图片url

	@Field(type = FieldType.Double)
	private Double cour_price;//课程价格

	@Field(type = FieldType.Double)
	private Double cour_nocount;//课程优惠价格

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_content;//课程描述

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_details;//课程详情

	@Field(type=FieldType.Integer)
	private Integer cour_pageview;//浏览量

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_score;//评分标准

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_target;//课程目标

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_resources;//参考资料

	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String cour_propaedeutics;//预备知识

	@Field(type = FieldType.Keyword)
	private String cour_isputaway;//是否上架

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String cour_closetime;//开课时间

	@Field(type = FieldType.Keyword)
	private String cour_classhour;//学时

	@Field(type = FieldType.Integer)
	private Integer cour_commentcount;//课程评价数量

	@Field(type = FieldType.Integer)
	private Integer cour_studypeople;//报名人数

	@Field(type = FieldType.Integer)
	private Integer cour_mark;//学分

	@Field(type = FieldType.Integer)
	private Integer ext1;
	@Field(type = FieldType.Keyword)
	private String ext2;
}
	
	
	
	
	
	