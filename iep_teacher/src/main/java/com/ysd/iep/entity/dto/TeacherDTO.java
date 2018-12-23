package com.ysd.iep.entity.dto;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("教师传输类")
@Data
public class TeacherDTO {
	@ApiModelProperty("教师id")
	private String teaId;
	@ApiModelProperty("教师姓名")
	private String teaName;
	@ApiModelProperty("教师工号")
	private Integer teaNumber;
	@ApiModelProperty("教师头像")
	private String teaPhoto;
	@ApiModelProperty("老师性别")
	private String teaSex;
	@ApiModelProperty("教师所属院系")
	private Integer teaDepartmentid;
	@ApiModelProperty("教师描述")
	private String teaDescribe;
	@ApiModelProperty("教师寄语")
	private String teaTalk;
	
}
